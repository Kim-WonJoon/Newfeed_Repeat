package com.example.newsfeed.comment.dto.responsedto;

import com.example.newsfeed.common.BaseTimeEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto extends BaseTimeEntity {

    private final Long postId;
    private final Long id;
    private final String name;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public CommentResponseDto(Long postId, Long id, String name, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
