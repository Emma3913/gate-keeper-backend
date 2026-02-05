package com.gatekeeper.user.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gatekeeper.user.domain.model.User;
import com.gatekeeper.user.domain.service.IUserService;
import com.gatekeeper.user.infrastructure.dto.CreateUserRequest;
import com.gatekeeper.user.infrastructure.dto.UserDto;
import com.gatekeeper.user.infrastructure.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @RequestBody CreateUserRequest request) {

        User user = User.builder()
                .username(request.username())
                .password(request.password())
                .build();

        User created = userService.createNewUser(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toDto(created));
    }
}
