package com.microservice.user.domain.factory;

import com.microservice.user.application.dto.user.CreateUserDto;
import com.microservice.user.domain.constants.role.RoleConstants;
import com.microservice.user.domain.exceptions.role.RoleNotFoundException;
import com.microservice.user.domain.exceptions.user.DuplicateEmailException;
import com.microservice.user.domain.exceptions.user.DuplicateIdDocumentException;
import com.microservice.user.domain.models.User;
import com.microservice.user.domain.ports.in.UserFactory;
import com.microservice.user.domain.ports.out.role.RoleRepositoryPort;
import com.microservice.user.domain.ports.out.user.UserRepositoryPort;
import com.microservice.user.domain.validations.UserValidator;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserFactoryImpl implements UserFactory {
    private final RoleRepositoryPort roleRepositoryPort;

    private final PasswordEncoder passwordEncoder;

    public UserFactoryImpl(RoleRepositoryPort roleRepositoryPort, PasswordEncoder passwordEncoder) {
        this.roleRepositoryPort = roleRepositoryPort;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Creates a new user with the role of the input.
     * This method validates the user, ensures that the user is unique, sets the role of the user,
     * encrypts the user's password, and saves the user to the repository.
     *
     * @param user the user to create
     * @param roleName the name of the role to assign to the user
     * @return the created user
     */

    @Override
    public User createUser(User user, String roleName) {
        setUserRole(user, roleName);
        encryptPassword(user);
        return user;
    }

    /**
     * Sets the role of the user to warehouse assistant.
     * This method queries the role repository to find the warehouse assistant role and assigns it to the user.
     *
     * @param user the user to set the role for
     * @throws RoleNotFoundException if the warehouse assistant role is not found
     */
    private void setUserRole(User user, String roleName){
        user.setRole(roleRepositoryPort.findRoleByName(roleName)
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
