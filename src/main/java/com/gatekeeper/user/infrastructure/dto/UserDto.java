package com.gatekeeper.user.infrastructure.dto;

import lombok.Builder;

import java.util.Set;

import com.gatekeeper.role.infrastructure.dto.RoleDto;

@Builder
public record UserDto(Long id,
    String username,
    Set<RoleDto> roles) {}
    