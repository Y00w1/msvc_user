package com.microservice.user.domain.ports.out.role;

import com.microservice.user.domain.models.Role;

import java.util.Optional;

public interface RoleRepositoryPort {
    Role saveRole(Role role);
    boolean roleExists(String roleName);
    Optional<Role> findRoleByName(String roleName);
}
