package com.example.newsfeed.user.controller;

import com.example.newsfeed.user.dto.requestdto.UserRequestDto;
import com.example.newsfeed.user.dto.responsedto.UserDetailResponseDto;
import com.example.newsfeed.user.dto.responsedto.UserResponseDto;
import com.example.newsfeed.user.entity.User;
import com.example.newsfeed.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<UserResponseDto> save(@RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.save(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserRequestDto dto) {
        User user = userService.login(dto.getEmail(), dto.getPassword());
        return ResponseEntity.ok(new UserResponseDto(user.getId(), user.getEmail(), user.getPassword(), user.getName(), user.getFollowerCount(), user.getFollowingCount()));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDetailResponseDto> findById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long userId, @RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.update(userId, dto));
    }

    @DeleteMapping("/users/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.deleteById(userId);
    }
}
