package com.gatekeeper.user.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.gatekeeper.role.infrastructure.mapper.RoleMapper;
import com.gatekeeper.user.domain.model.User;
import com.gatekeeper.user.infrastructure.dto.UserDto;
import com.gatekeeper.user.infrastructure.persistence.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {

        private final RoleMapper roleMapper;

        public UserEntity toEntity(User user) {
                if (user == null)
                        return null;

                return UserEntity.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .password(user.getPassword())
                                .isEnabled(user.getIsEnabled())
                                .accountNoExpired(user.getAccountNoExpired())
                                .accountNoLocked(user.getAccountNoLocked())
                                .credentialNoExpired(user.getCredentialNoExpired())
                                .roles(roleMapper.toRoleEntitySet(user.getRoles()))
                                .build();
        }

        public User toDomain(UserEntity entity) {
                if (entity == null)
                        return null;

                return User.builder()
                                .id(entity.getId())
                                .username(entity.getUsername())
                                .password(entity.getPassword())
                                .isEnabled(entity.isEnabled())
                                .accountNoExpired(entity.isAccountNoExpired())
                                .accountNoLocked(entity.isAccountNoLocked())
                                .credentialNoExpired(entity.isCredentialNoExpired())
                                .roles(roleMapper.toRoleDomainSet(entity.getRoles()))
                                .build();
        }

        public UserDto toDto(User user) {
                if (user == null)
                        return null;

                return UserDto.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .roles(roleMapper.toRoleDtoSet(user.getRoles()))
                                .build();
        }
}
