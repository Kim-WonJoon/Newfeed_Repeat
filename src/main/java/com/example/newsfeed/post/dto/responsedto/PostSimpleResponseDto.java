package com.example.newsfeed.post.dto.responsedto;

import lombok.Getter;

@Getter
public class PostSimpleResponseDto {

    private final Long id;
    private final String title;

    public PostSimpleResponseDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
