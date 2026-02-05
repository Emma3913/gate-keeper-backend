package com.gatekeeper.user.infrastructure.dto;

public record CreateUserRequest(
    String username,
    String password
) {}
