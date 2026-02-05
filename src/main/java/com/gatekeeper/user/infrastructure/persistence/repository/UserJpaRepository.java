package com.gatekeeper.user.infrastructure.persistence.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gatekeeper.user.infrastructure.persistence.entity.UserEntity;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findUserEntityByUsername(String username);
}
