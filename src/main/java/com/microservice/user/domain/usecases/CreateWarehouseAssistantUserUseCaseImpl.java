package com.microservice.user.domain.usecases;

import com.microservice.user.domain.constants.role.RoleConstants;
import com.microservice.user.domain.exceptions.user.DuplicateEmailException;
import com.microservice.user.domain.exceptions.user.DuplicateIdDocumentException;
import com.microservice.user.domain.models.User;
import com.microservice.user.domain.ports.in.CreateWarehouseAssistantUserUseCase;
import com.microservice.user.domain.ports.in.UserFactory;
import com.microservice.user.domain.ports.out.user.UserRepositoryPort;
import com.microservice.user.domain.validations.UserValidator;

/**
 * Use case implementation for creating a warehouse assistant user.
 * This class handles the business logic for creating a new user with the role of warehouse assistant.
 */
public class CreateWarehouseAssistantUserUseCaseImpl implements CreateWarehouseAssistantUserUseCase {
    private final UserFactory userFactory;

    private final UserRepositoryPort userRepositoryPort;

    private final UserValidator userValidator;

    public CreateWarehouseAssistantUserUseCaseImpl(UserFactory userFactory, UserRepositoryPort userRepositoryPort, UserValidator userValidator) {
        this.userFactory = userFactory;
        this.userRepositoryPort = userRepositoryPort;
        this.userValidator = userValidator;
    }

    /**
     * By using the user factory, creates a new user with the role of warehouse assistant.
     * @param user
     * @return the created user
     */
    @Override
    public User createWarehouseAssistantUser(User user) {
        User newUser = userFactory.createUser(user, RoleConstants.WAREHOUSE_ASSISTANT);
        userValidator.validate(newUser);
        validateUniqueUser(newUser);
        return userRepositoryPort.createUser(newUser);
    }

    /**
     * Validates that the user is unique by checking email and ID document.
     * This method queries the user repository to ensure that no other user exists with the same email or ID document.
     *
     * @param user the user to validate
     * @throws DuplicateEmailException if the email is already in use
     * @throws DuplicateIdDocumentException if the ID document is already in use
     */
    private void validateUniqueUser(User user) {
        if (userRepositoryPort.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateEmailException(user.getEmail());        }
        if (userRepositoryPort.findByIdDocument(user.getIdDocument()).isPresent()) {
            throw new DuplicateIdDocumentException(user.getIdDocument());
        }
    }
}
