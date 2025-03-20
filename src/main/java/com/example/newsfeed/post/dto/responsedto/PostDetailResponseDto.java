package com.example.newsfeed.post.dto.responsedto;

import com.example.newsfeed.comment.dto.responsedto.CommentSimpleResponseDto;
import com.example.newsfeed.common.BaseTimeEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostDetailResponseDto extends BaseTimeEntity {

    private final Long id;
    private final String name;
    private final String title;
    private final String content;
    private final List<CommentSimpleResponseDto> comments;
    private final Long likesCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public PostDetailResponseDto(Long id, String name, String title, String content, List<CommentSimpleResponseDto> comments, Long likesCount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.comments = comments;
        this.likesCount = likesCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
