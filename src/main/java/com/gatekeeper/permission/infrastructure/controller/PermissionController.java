package com.gatekeeper.permission.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gatekeeper.permission.domain.model.Permission;
import com.gatekeeper.permission.domain.service.IPermissionService;
import com.gatekeeper.permission.infrastructure.dto.CreatePermissionRequest;
import com.gatekeeper.permission.infrastructure.dto.PermissionDto;
import com.gatekeeper.permission.infrastructure.mapper.PermissionMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final IPermissionService permissionService;
    private final PermissionMapper permissionMapper;

    @PostMapping
    public ResponseEntity<PermissionDto> createPermission(
            @RequestBody CreatePermissionRequest request) {

        Permission permission = Permission.builder()
                .name(request.name())
                .build();

        Permission created = permissionService.createNewPermission(permission);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(permissionMapper.toDto(created));
    }
}
