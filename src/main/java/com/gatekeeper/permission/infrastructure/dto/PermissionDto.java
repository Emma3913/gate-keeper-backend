package com.gatekeeper.permission.infrastructure.dto;

import lombok.Builder;
@Builder
public record PermissionDto(
    Long id,
    String name
) {}