package com.gatekeeper.role.domain.model;

import java.util.HashSet;
import java.util.Set;

import com.gatekeeper.permission.domain.model.Permission;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {
    private Long id;
    private RoleEnum roleEnum;
    private Set<Permission> permissionList = new HashSet<>();
}
