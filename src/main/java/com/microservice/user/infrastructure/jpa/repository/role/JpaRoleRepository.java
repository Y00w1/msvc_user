package com.microservice.user.infrastructure.jpa.repository.role;

import com.microservice.user.infrastructure.jpa.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRoleRepository extends JpaRepository<RoleEntity, Long> {
    boolean existsByName(String name);
    Optional<RoleEntity> findByName(String roleName);
}
