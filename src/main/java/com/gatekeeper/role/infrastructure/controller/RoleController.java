package com.gatekeeper.role.infrastructure.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gatekeeper.role.domain.model.Role;
import com.gatekeeper.role.domain.model.RoleEnum;
import com.gatekeeper.role.domain.service.IRoleService;
import com.gatekeeper.role.infrastructure.dto.CreateRoleRequest;
import com.gatekeeper.role.infrastructure.dto.RoleDto;
import com.gatekeeper.role.infrastructure.mapper.RoleMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;
    private final RoleMapper roleMapper;

    @PostMapping
    public ResponseEntity<RoleDto> createRole(
            @RequestBody CreateRoleRequest request) {

        Role role = Role.builder()
                .roleEnum(RoleEnum.valueOf(request.role()))
                .permissionList(Set.of()) 
                .build();

        Role created = roleService.createNewRole(role);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roleMapper.toDto(created));
    }
}
