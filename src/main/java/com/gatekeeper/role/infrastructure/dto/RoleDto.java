package com.gatekeeper.role.infrastructure.dto;

import lombok.Builder;

import java.util.Set;

import com.gatekeeper.permission.infrastructure.dto.PermissionDto;
import com.gatekeeper.role.domain.model.RoleEnum;

@Builder
public record RoleDto(Long id,
        RoleEnum roleEnum,
        Set<PermissionDto> permissions) {
}
