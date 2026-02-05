package com.gatekeeper.user.domain.port;

import com.gatekeeper.user.domain.model.User;
import com.gatekeeper.user.infrastructure.persistence.entity.UserEntity;

public interface IUserRepository {
    User save(UserEntity userEntity);
    User findUserEntityByUsername(String username);
} 
