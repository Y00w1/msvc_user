package com.microservice.user.domain.usecases;

import com.microservice.user.domain.constants.role.RoleConstants;
import com.microservice.user.domain.exceptions.role.RoleNotFoundException;
import com.microservice.user.domain.exceptions.user.DuplicateEmailException;
import com.microservice.user.domain.exceptions.user.DuplicateIdDocumentException;
import com.microservice.user.domain.models.User;
import com.microservice.user.domain.ports.in.CreateWarehouseAssistantUserUseCase;
import com.microservice.user.domain.ports.out.role.RoleRepositoryPort;
import com.microservice.user.domain.ports.out.user.UserRepositoryPort;
import com.microservice.user.domain.validations.UserValidator;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateWarehouseAssistantUserUseCaseImpl implements CreateWarehouseAssistantUserUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final RoleRepositoryPort roleRepositoryPort;

    private final UserValidator userValidator;

    private final PasswordEncoder passwordEncoder;

    public CreateWarehouseAssistantUserUseCaseImpl(UserRepositoryPort userRepositoryPort, RoleRepositoryPort roleRepositoryPort, UserValidator userValidator, PasswordEncoder passwordEncoder) {
        this.userRepositoryPort = userRepositoryPort;
        this.roleRepositoryPort = roleRepositoryPort;
        this.userValidator = userValidator;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createWarehouseAssistantUser(User user) {
        userValidator.validate(user);
        validateUniqueUser(user);
        setUserRole(user);
        encryptPassword(user);
        return userRepositoryPort.createUser(user);
    }

    private void validateUniqueUser(User user) {
        if (userRepositoryPort.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateEmailException(user.getEmail());        }
        if (userRepositoryPort.findByIdDocument(user.getIdDocument()).isPresent()) {
            throw new DuplicateIdDocumentException(user.getIdDocument());
        }
    }

    private void setUserRole(User user){
        user.setRole(roleRepositoryPort.findRoleByName(RoleConstants.WAREHOUSE_ASSISTANT)
                .orElseThrow(RoleNotFoundException::new));
    }

    private void encryptPassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
