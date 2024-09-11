package com.microservice.user.infrastructure.jpa.repository.role;

import com.microservice.user.domain.models.Role;
import com.microservice.user.domain.ports.out.role.RoleRepositoryPort;
import com.microservice.user.infrastructure.jpa.entities.RoleEntity;
import com.microservice.user.infrastructure.jpa.mapper.RoleEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaRoleRepositoryAdapter implements RoleRepositoryPort {
    private final JpaRoleRepository jpaRoleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Role saveRole(Role role) {
        RoleEntity roleEntity = roleEntityMapper.toEntity(role);
        return roleEntityMapper.toDomain(jpaRoleRepository.save(roleEntity));
    }

    @Override
    public boolean roleExists(String roleName) {
        return jpaRoleRepository.existsByName(roleName);
    }

    @Override
    public Optional<Role> findRoleByName(String roleName) {
        return jpaRoleRepository.findByName(roleName).map(roleEntityMapper::toDomain);
    }
}
