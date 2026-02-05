package com.gatekeeper.permission.application;

import org.springframework.stereotype.Service;

import com.gatekeeper.permission.domain.model.Permission;
import com.gatekeeper.permission.domain.service.IPermissionService;
import com.gatekeeper.permission.infrastructure.mapper.PermissionMapper;
import com.gatekeeper.permission.infrastructure.persistence.repository.PermissionRepositoryImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements IPermissionService {

    private final PermissionRepositoryImpl permissionRepositoryImpl;
    private final PermissionMapper permissionMapper;

    @Override
    public Permission createNewPermission(Permission permission) {
        Permission newPermission = Permission.builder()
                .name(permission.getName())
                .build();
        return permissionRepositoryImpl.save(permissionMapper.toEntity(newPermission));
    }
}
