package com.gatekeeper.user.application;

import org.springframework.stereotype.Service;

import com.gatekeeper.user.domain.model.User;
import com.gatekeeper.user.domain.service.IUserService;
import com.gatekeeper.user.infrastructure.mapper.UserMapper;
import com.gatekeeper.user.infrastructure.persistence.repository.UserRepositoryImpl;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepositoryImpl userRepositoryImpl;
    private final UserMapper userMapper;

    @Override
    public User createNewUser(User user) {
        User newUser = User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .accountNoExpired(true)
                .accountNoLocked(true)
                .isEnabled(true)
                .credentialNoExpired(true)
                // .roles(Set.of(userRole))
                .roles(null)
                .build();

        return userRepositoryImpl.save(userMapper.toEntity(newUser));
    }
}
