package com.example.newsfeed.post.dto.requestdto;

import lombok.Getter;

@Getter
public class PostRequestDto {

    private Long userId;
    private String name;
    private String title;
    private String content;
}
