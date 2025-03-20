package com.example.newsfeed.comment.dto.responsedto;

import com.example.newsfeed.common.BaseTimeEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSimpleResponseDto extends BaseTimeEntity {

    private final Long id;
    private final String name;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public CommentSimpleResponseDto(Long id, String name, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
