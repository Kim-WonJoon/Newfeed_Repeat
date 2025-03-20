package com.example.newsfeed.follow.controller;

import com.example.newsfeed.follow.service.FollowService;
import com.example.newsfeed.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FollowController {

    private final UserService userService;
    private final FollowService followService;

}
