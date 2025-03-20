package com.example.newsfeed.comment.controller;

import com.example.newsfeed.comment.dto.requestdto.CommentRequestDto;
import com.example.newsfeed.comment.dto.responsedto.CommentResponseDto;
import com.example.newsfeed.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentResponseDto> save(@PathVariable Long postId, @RequestBody CommentRequestDto dto) {
        return ResponseEntity.ok(commentService.save(postId, dto));
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentResponseDto>> findAll(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.findAll(postId));
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> findById(@PathVariable Long postId, Long commentId) {
        return ResponseEntity.ok(commentService.findById(postId, commentId));
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> update(@PathVariable Long postId, Long commentId, @RequestBody CommentRequestDto dto) {
        return ResponseEntity.ok(commentService.update(postId, commentId, dto));
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public void delete(@PathVariable Long postId, Long commentId) {
        commentService.deleteById(postId, commentId);
    }

}
