package com.gatekeeper.permission.infrastructure.persistence.repository;

import org.springframework.stereotype.Component;

import com.gatekeeper.permission.domain.model.Permission;
import com.gatekeeper.permission.domain.port.IPermissionRepository;
import com.gatekeeper.permission.infrastructure.mapper.PermissionMapper;
import com.gatekeeper.permission.infrastructure.persistence.entity.PermissionEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PermissionRepositoryImpl implements IPermissionRepository {

    private final PermissionJpaRepository permissionJpaRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public Permission save(PermissionEntity permissionEntity) {
        PermissionEntity saved = permissionJpaRepository.save(permissionEntity);
        return permissionMapper.toPermission(saved);
    }
}
