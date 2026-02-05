package com.gatekeeper.permission.infrastructure.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gatekeeper.permission.domain.model.Permission;
import com.gatekeeper.permission.infrastructure.dto.PermissionDto;
import com.gatekeeper.permission.infrastructure.persistence.entity.PermissionEntity;

@Component
public class PermissionMapper {

        public PermissionEntity toEntity(Permission permission) {
                if (permission == null)
                        return null;

                return PermissionEntity.builder()
                                .id(permission.getId())
                                .name(permission.getName())
                                .build();
        }

        public Permission toPermission(PermissionEntity permissionEntity) {
                return Permission.builder()
                                .id(permissionEntity.getId())
                                .name(permissionEntity.getName())
                                .build();
        }
        
        public PermissionDto toDto(Permission permission) {
                return PermissionDto.builder()
                                .id(permission.getId())
                                .name(permission.getName())
                                .build();
        }

        public Set<PermissionEntity> toPermissionEntitySet(Set<Permission> permissions) {
                if (permissions == null)
                        return Set.of();

                return permissions.stream()
                                .map(permission -> PermissionEntity.builder()
                                                .id(permission.getId())
                                                .name(permission.getName())
                                                .build())
                                .collect(Collectors.toSet());
        }

        public Set<Permission> toPermissionDomainSet(Set<PermissionEntity> entities) {
                if (entities == null)
                        return Set.of();

                return entities.stream()
                                .map(entity -> Permission.builder()
                                                .id(entity.getId())
                                                .name(entity.getName())
                                                .build())
                                .collect(Collectors.toSet());
        }

        public Set<PermissionDto> toPermissionDtoSet(Set<Permission> permissions) {
                if (permissions == null)
                        return Set.of();

                return permissions.stream()
                                .map(permission -> PermissionDto.builder()
                                                .id(permission.getId())
                                                .name(permission.getName())
                                                .build())
                                .collect(Collectors.toSet());
        }

}
