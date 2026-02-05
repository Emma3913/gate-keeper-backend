package com.gatekeeper.role.domain.port;

import com.gatekeeper.role.domain.model.Role;
import com.gatekeeper.role.infrastructure.persistence.entity.RoleEntity;

public interface IRoleRepository {
    Role save(RoleEntity roleEntity);
} 
