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

/**
 * Use case implementation for creating a warehouse assistant user.
 * This class handles the business logic for creating a new user with the role of warehouse assistant.
 */
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

    /**
     * Creates a warehouse assistant user.
     * This method validates the user, checks for uniqueness, sets the user's role, encrypts the password, and saves the user.
     *
     * @param user the user to create
     * @return the created user
     * @throws DuplicateEmailException if the email is already in use
     * @throws DuplicateIdDocumentException if the ID document is already in use
     * @throws RoleNotFoundException if the warehouse assistant role is not found
     */
    @Override
    public User createWarehouseAssistantUser(User user) {
        userValidator.validate(user);
        validateUniqueUser(user);
        setUserRole(user);
        encryptPassword(user);
        return userRepositoryPort.createUser(user);
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

    /**
     * Sets the role of the user to warehouse assistant.
     * This method queries the role repository to find the warehouse assistant role and assigns it to the user.
     *
     * @param user the user to set the role for
     * @throws RoleNotFoundException if the warehouse assistant role is not found
     */
    private void setUserRole(User user){
        user.setRole(roleRepositoryPort.findRoleByName(RoleConstants.WAREHOUSE_ASSISTANT)
                .orElseThrow(RoleNotFoundException::new));
    }

    /**
     * Encrypts the user's password.
     * This method uses the password encoder to encrypt the user's password before saving it to the repository.
     *
     * @param user the user whose password to encrypt
     */
    private void encryptPassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
