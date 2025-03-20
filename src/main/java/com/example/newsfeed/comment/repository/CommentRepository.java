package com.example.newsfeed.comment.repository;

import com.example.newsfeed.comment.entity.Comment;
import com.example.newsfeed.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
