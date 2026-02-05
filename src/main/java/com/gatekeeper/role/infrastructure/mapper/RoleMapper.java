package com.gatekeeper.role.infrastructure.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gatekeeper.permission.infrastructure.mapper.PermissionMapper;
import com.gatekeeper.role.domain.model.Role;
import com.gatekeeper.role.infrastructure.dto.RoleDto;
import com.gatekeeper.role.infrastructure.persistence.entity.RoleEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RoleMapper {

    private final PermissionMapper permissionMapper;

    public RoleEntity toEntity(Role role) {
        if (role == null)
            return null;

        return RoleEntity.builder()
                .id(role.getId())
                .roleEnum(role.getRoleEnum())
                .permissionList(permissionMapper.toPermissionEntitySet(role.getPermissionList()))
                .build();
    }

    public Role toRole(RoleEntity roleEntity) {
        return Role.builder()
                .roleEnum(roleEntity.getRoleEnum())
                .permissionList(permissionMapper.toPermissionDomainSet(roleEntity.getPermissionList()))
                .build();
    }

    public RoleDto toDto(Role role) {
        return RoleDto.builder()
                .roleEnum(role.getRoleEnum())
                .permissions(permissionMapper.toPermissionDtoSet(role.getPermissionList()))
                .build();
    }

    public Set<RoleEntity> toRoleEntitySet(Set<Role> roles) {
        if (roles == null)
            return Set.of();

        return roles.stream()
                .map(role -> RoleEntity.builder()
                        .id(role.getId())
                        .roleEnum(role.getRoleEnum())
                        .permissionList(permissionMapper.toPermissionEntitySet(role.getPermissionList()))
                        .build())
                .collect(Collectors.toSet());
    }

    public Set<Role> toRoleDomainSet(Set<RoleEntity> entities) {
        if (entities == null)
            return Set.of();

        return entities.stream()
                .map(entity -> Role.builder()
                        .id(entity.getId())
                        .roleEnum(entity.getRoleEnum())
                        .permissionList(permissionMapper.toPermissionDomainSet(entity.getPermissionList()))
                        .build())
                .collect(Collectors.toSet());
    }

    public Set<RoleDto> toRoleDtoSet(Set<Role> roles) {
        if (roles == null)
            return Set.of();

        return roles.stream()
                .map(role -> RoleDto.builder()
                        .id(role.getId())
                        .roleEnum(role.getRoleEnum())
                        .permissions(permissionMapper.toPermissionDtoSet(role.getPermissionList()))
                        .build())
                .collect(Collectors.toSet());
    }
}
