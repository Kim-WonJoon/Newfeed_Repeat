package com.example.newsfeed.post.controller;

import com.example.newsfeed.post.dto.requestdto.PostRequestDto;
import com.example.newsfeed.post.dto.responsedto.PostDetailResponseDto;
import com.example.newsfeed.post.dto.responsedto.PostResponseDto;
import com.example.newsfeed.post.dto.responsedto.PostSimpleResponseDto;
import com.example.newsfeed.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<PostResponseDto> save(@RequestBody PostRequestDto dto) {
        return ResponseEntity.ok(postService.save(dto));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostSimpleResponseDto>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDetailResponseDto> findById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.findById(postId));
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostResponseDto> update(@PathVariable Long postId, @RequestBody PostRequestDto dto) {
        return ResponseEntity.ok(postService.update(postId, dto));
    }

    @DeleteMapping("/posts/{postId}")
    public void delete(@PathVariable Long postId) {
        postService.deleteById(postId);
    }
}
