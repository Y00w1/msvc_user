package com.microservice.user.infrastructure.initializer;

import com.microservice.user.domain.constants.role.RoleConstants;
import com.microservice.user.domain.models.Role;
import com.microservice.user.domain.ports.out.role.RoleRepositoryPort;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoleInitializer {
    private final RoleRepositoryPort roleRepositoryPort;

    @PostConstruct
    public void initializeRoles(){
        addRoleIfNotExists(RoleConstants.WAREHOUSE_ASSISTANT);
    }
    private void addRoleIfNotExists(String roleName) {
        if (!roleRepositoryPort.roleExists(roleName)) {
            Role role = new Role();
            role.setName(roleName);
            roleRepositoryPort.saveRole(role);
        }
    }
}
