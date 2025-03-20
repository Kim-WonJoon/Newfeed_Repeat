package com.example.newsfeed.comment.service;

import com.example.newsfeed.comment.dto.requestdto.CommentRequestDto;
import com.example.newsfeed.comment.dto.responsedto.CommentResponseDto;
import com.example.newsfeed.comment.entity.Comment;
import com.example.newsfeed.comment.repository.CommentRepository;
import com.example.newsfeed.post.entity.Post;
import com.example.newsfeed.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponseDto save(Long postId, CommentRequestDto dto) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalStateException("해당 게시글이 존재하지 않습니다")
        );

        Comment comment = new Comment(post, dto.getName(), dto.getContent());
        Comment savedComment = commentRepository.save(comment);
        return new CommentResponseDto(post.getId(), savedComment.getId(), savedComment.getName(), savedComment.getContent(), savedComment.getCreatedAt(), savedComment.getUpdatedAt());
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDto> findAll(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalStateException("해당 게시글이 존재하지 않습니다")
        );

        List<Comment> comments = commentRepository.findAll();

        List<CommentResponseDto> dtos = new ArrayList<>();
        for (Comment comment : comments) {
            dtos.add(new CommentResponseDto(post.getId(), comment.getId(), comment.getName(), comment.getContent(), comment.getCreatedAt(), comment.getUpdatedAt()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public CommentResponseDto findById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalStateException("해당 게시글이 존재하지 않습니다")
        );

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalStateException("해당 댓글을 찾을 수 없습니다")
        );
        return new CommentResponseDto(post.getId(), comment.getId(), comment.getName(), comment.getContent(), comment.getCreatedAt(), comment.getUpdatedAt());
    }

    @Transactional
    public CommentResponseDto update(Long postId, Long commentId, CommentRequestDto dto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalStateException("해당 게시글이 존자하지 않습니다")
        );

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalStateException("해당 댓글을 찾을 수 없습니다")
        );
        comment.update(dto.getContent());
        return new CommentResponseDto(post.getId(), comment.getId(), comment.getName(), comment.getContent(), comment.getCreatedAt(), comment.getUpdatedAt());
    }

    @Transactional
    public void deleteById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalStateException("해당 게시글이 존자하지 않습니다")
        );

        if (!commentRepository.existsById(commentId)) {
            throw new IllegalStateException("해당 댓글을 찾을 수 없습니다");
        }
        commentRepository.deleteById(commentId);
    }
}
