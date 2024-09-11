package com.microservice.user.domain.ports.in;

import com.microservice.user.domain.models.User;

public interface CreateWarehouseAssistantUserUseCase {
    User createWarehouseAssistantUser(User user);
}
