package com.gatekeeper.role.infrastructure.persistence.repository;

import org.springframework.stereotype.Component;

import com.gatekeeper.role.domain.model.Role;
import com.gatekeeper.role.domain.port.IRoleRepository;
import com.gatekeeper.role.infrastructure.mapper.RoleMapper;
import com.gatekeeper.role.infrastructure.persistence.entity.RoleEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RoleRepositoryImpl implements IRoleRepository {

    private final RoleJpaRepository userJpaRepository;
    private final RoleMapper roleMapper;

    @Override
    public Role save(RoleEntity roleEntity) {
        RoleEntity saved = userJpaRepository.save(roleEntity);
        return roleMapper.toRole(saved);
    }
}
