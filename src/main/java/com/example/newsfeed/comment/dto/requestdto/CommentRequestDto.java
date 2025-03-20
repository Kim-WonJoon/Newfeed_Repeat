package com.example.newsfeed.comment.dto.requestdto;

import lombok.Getter;

@Getter
public class CommentRequestDto {

    private Long postId;
    private String name;
    private String content;
}
