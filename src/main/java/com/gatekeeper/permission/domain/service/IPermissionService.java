package com.gatekeeper.permission.domain.service;

import com.gatekeeper.permission.domain.model.Permission;

public interface IPermissionService {
    Permission createNewPermission(Permission user);
}
