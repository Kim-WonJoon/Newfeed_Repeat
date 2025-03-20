package com.example.newsfeed.post.service;

import com.example.newsfeed.comment.dto.responsedto.CommentSimpleResponseDto;
import com.example.newsfeed.comment.entity.Comment;
import com.example.newsfeed.comment.repository.CommentRepository;
import com.example.newsfeed.post.dto.requestdto.PostRequestDto;
import com.example.newsfeed.post.dto.responsedto.PostDetailResponseDto;
import com.example.newsfeed.post.dto.responsedto.PostResponseDto;
import com.example.newsfeed.post.dto.responsedto.PostSimpleResponseDto;
import com.example.newsfeed.post.entity.Post;
import com.example.newsfeed.post.repository.PostRepository;
import com.example.newsfeed.user.entity.User;
import com.example.newsfeed.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    @Transactional
    public PostResponseDto save(PostRequestDto dto) {
        Post post = new Post(dto.getName(), dto.getTitle(), dto.getTitle());
        Post savedPost = postRepository.save(post);
        return new PostResponseDto(savedPost.getId(), savedPost.getName(), savedPost.getTitle(), savedPost.getContent(), savedPost.getCreatedAt(), savedPost.getUpdatedAt());
    }

    @Transactional(readOnly = true)
    public List<PostSimpleResponseDto> findAll() {
        List<Post> posts = postRepository.findAll();

        List<PostSimpleResponseDto> dtos = new ArrayList<>();

        for (Post post : posts) {
            dtos.add(new PostSimpleResponseDto(post.getId(), post.getTitle()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public PostDetailResponseDto findById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalStateException("해당 게시물을 찾을 수 없습니다")
        );

        List<Comment> comments = commentRepository.findByPost(post);

        List<CommentSimpleResponseDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentSimpleResponseDto commentSimpleResponseDto = new CommentSimpleResponseDto(
                    comment.getId(), comment.getName(), comment.getContent(), comment.getCreatedAt(), comment.getUpdatedAt()
            );

            commentDtos.add(commentSimpleResponseDto);
        }

        return new PostDetailResponseDto(
                post.getId(), post.getName(), post.getTitle(), post.getContent(), commentDtos, post.getLikesCount(), post.getCreatedAt(), post.getUpdatedAt());
    }

    @Transactional
    public PostResponseDto update(Long postId, PostRequestDto dto) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalStateException("해당 게시물을 찾을 수 없습니다")
        );
        post.update(dto.getTitle(), dto.getContent());
        return new PostResponseDto(post.getId(), post.getName(), post.getTitle(), post.getContent(), post.getCreatedAt(), post.getUpdatedAt());
    }

    @Transactional
    public void deleteById(Long postId) {

        if (!postRepository.existsById(postId)) {
            throw new IllegalStateException("해당 게시물을 찾을 수 없습니다");
        }
        userRepository.deleteById(postId);
    }
}
