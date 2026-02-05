package com.gatekeeper.role.application;

import org.springframework.stereotype.Service;

import com.gatekeeper.role.domain.model.Role;
import com.gatekeeper.role.domain.service.IRoleService;
import com.gatekeeper.role.infrastructure.mapper.RoleMapper;
import com.gatekeeper.role.infrastructure.persistence.repository.RoleRepositoryImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final RoleRepositoryImpl roleRepositoryImpl;
    private final RoleMapper roleMapper;

    @Override
    public Role createNewRole(Role role) {
         Role newRole = Role.builder()
                .roleEnum(role.getRoleEnum())
                .permissionList(role.getPermissionList())
                .build();

                return roleRepositoryImpl.save(roleMapper.toEntity(newRole));
    }
}
