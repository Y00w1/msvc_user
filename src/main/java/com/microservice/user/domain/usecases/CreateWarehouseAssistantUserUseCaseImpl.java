package com.microservice.user.domain.usecases;

import com.microservice.user.domain.constants.role.RoleConstants;
import com.microservice.user.domain.models.User;
import com.microservice.user.domain.ports.in.CreateWarehouseAssistantUserUseCase;
import com.microservice.user.domain.ports.in.UserFactory;

/**
 * Use case implementation for creating a warehouse assistant user.
 * This class handles the business logic for creating a new user with the role of warehouse assistant.
 */
public class CreateWarehouseAssistantUserUseCaseImpl implements CreateWarehouseAssistantUserUseCase {
    private final UserFactory userFactory;

    public CreateWarehouseAssistantUserUseCaseImpl(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    /**
     * By using the user factory, creates a new user with the role of warehouse assistant.
     * @param user
     * @return the created user
     */
    @Override
    public User createWarehouseAssistantUser(User user) {
        return userFactory.createUser(user, RoleConstants.WAREHOUSE_ASSISTANT);
    }
}
