package com.gatekeeper.user.infrastructure.persistence.repository;

import org.springframework.stereotype.Component;

import com.gatekeeper.user.domain.model.User;
import com.gatekeeper.user.domain.port.IUserRepository;
import com.gatekeeper.user.infrastructure.mapper.UserMapper;
import com.gatekeeper.user.infrastructure.persistence.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements IUserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User save(UserEntity userEntity) {
        UserEntity saved = userJpaRepository.save(userEntity);
        return userMapper.toDomain(saved);
    }

    @Override
    public User findUserEntityByUsername(String username) {
        UserEntity userEntity = userJpaRepository.findUserEntityByUsername(username).orElse(null);
        return userMapper.toDomain(userEntity);
    }
}
