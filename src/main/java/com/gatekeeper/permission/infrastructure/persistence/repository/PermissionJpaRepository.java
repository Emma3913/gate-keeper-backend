package com.gatekeeper.permission.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gatekeeper.permission.infrastructure.persistence.entity.PermissionEntity;

@Repository
public interface PermissionJpaRepository extends JpaRepository<PermissionEntity, Long>{
    // Optional<UserEntity> findUserEntityByUsername(String username);
}
