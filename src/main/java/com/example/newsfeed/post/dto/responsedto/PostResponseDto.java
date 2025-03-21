package com.example.newsfeed.post.dto.responsedto;

import com.example.newsfeed.comment.dto.responsedto.CommentSimpleResponseDto;
import com.example.newsfeed.common.BaseTimeEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostResponseDto extends BaseTimeEntity {

    private final Long id;
    private final String name;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public PostResponseDto(Long id, String name, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
