package com.gatekeeper.permission.domain.port;


import com.gatekeeper.permission.domain.model.Permission;
import com.gatekeeper.permission.infrastructure.persistence.entity.PermissionEntity;

public interface IPermissionRepository {
    Permission save(PermissionEntity permissionEntity);
} 
