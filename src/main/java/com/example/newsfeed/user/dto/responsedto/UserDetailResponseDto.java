package com.example.newsfeed.user.dto.responsedto;

import lombok.Getter;

@Getter
public class UserDetailResponseDto {

    private final Long id;
    private final String email;
    private final String username;
    private final Long followerCount;
    private final Long followingCount;

    public UserDetailResponseDto(Long id, String email, String username, Long followerCount, Long followingCount) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
    }
}
