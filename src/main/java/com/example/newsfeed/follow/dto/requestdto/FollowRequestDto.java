package com.example.newsfeed.follow.dto.requestdto;

import com.example.newsfeed.user.entity.User;
import lombok.Getter;

@Getter
public class FollowRequestDto {

    private User followers;
    private User followings;
    private Long userId;
}
