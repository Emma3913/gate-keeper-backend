package com.gatekeeper.role.infrastructure.dto;

import java.util.Set;

public record CreateRoleRequest(
    String role,
    Set<Long> permissionIds
) {}
