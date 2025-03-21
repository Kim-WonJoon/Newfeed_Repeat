package com.example.newsfeed.user.dto.responsedto;

import com.example.newsfeed.user.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private final Long id;
    private final String email;
    private final String password;
    private final String name;
    private final Long followerCount;
    private final Long followingCount;


    public UserResponseDto(Long id, String email, String password, String name, Long followerCount, Long followingCount) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
    }
}

