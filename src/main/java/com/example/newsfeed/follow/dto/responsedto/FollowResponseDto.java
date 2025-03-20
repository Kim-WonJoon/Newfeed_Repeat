package com.example.newsfeed.follow.dto.responsedto;

import com.example.newsfeed.user.entity.User;
import lombok.Getter;

@Getter
public class FollowResponseDto {

    private final User followers;
    private final User followings;
    private final Long userId;

    public FollowResponseDto(User followers, User followings, Long userId) {
        this.followers = followers;
        this.followings = followings;
        this.userId = userId;
    }
}
