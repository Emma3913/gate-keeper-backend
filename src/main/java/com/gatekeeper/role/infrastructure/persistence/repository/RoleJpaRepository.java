package com.gatekeeper.role.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gatekeeper.role.infrastructure.persistence.entity.RoleEntity;

@Repository
public interface RoleJpaRepository extends JpaRepository<RoleEntity, Long>{
    // Optional<UserEntity> findUserEntityByUsername(String username);
}
