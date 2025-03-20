package com.example.newsfeed.user.service;

import com.example.newsfeed.config.PasswordEncoder;
import com.example.newsfeed.user.dto.requestdto.UserRequestDto;
import com.example.newsfeed.user.dto.responsedto.UserDetailResponseDto;
import com.example.newsfeed.user.dto.responsedto.UserResponseDto;
import com.example.newsfeed.user.entity.User;
import com.example.newsfeed.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDto save(UserRequestDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalStateException("이미 사용중인 이메일입니다");
        }

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        User user = new User(dto.getEmail(), encodedPassword, dto.getName());
        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser.getId(), savedUser.getEmail(), savedUser.getPassword(), savedUser.getName(), savedUser.getFollowerCount(), savedUser.getFollowingCount());
    }

    @Transactional
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalStateException("잘못된 이메일이나 비밀번호입니다."));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalStateException("잘못된 이메일이나 비밀번호입니다.");
        }

        return user;
    }

    @Transactional(readOnly = true)
    public UserDetailResponseDto findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 유저를 찾을 수 없습니다.")
        );
        return new UserDetailResponseDto(user.getId(), user.getEmail(), user.getName(), user.getFollowerCount(), user.getFollowingCount());
    }

    @Transactional
    public UserResponseDto update(Long userId, UserRequestDto dto) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 유저를 찾을 수 없습니다.")
        );

        String newPassword = dto.getPassword();
        if (newPassword != null && !newPassword.isBlank()) {
            newPassword = passwordEncoder.encode(newPassword);
        } else {
            newPassword = user.getPassword();
        }

        user.update(dto.getName(), newPassword);
        return new UserResponseDto(user.getId(), user.getEmail(), user.getPassword(), user.getName(), user.getFollowerCount(), user.getFollowingCount());
    }

    @Transactional
    public void deleteById(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalStateException("해당 유저를 찾을 수 없습니다");
        }
        userRepository.deleteById(userId);
    }
}
