package com.microservice.user.application.services;

import com.microservice.user.application.dto.user.CreateUserWarehouseAssistantDto;
import com.microservice.user.application.dto.user.UserDto;

public interface UserService {
    UserDto createWarehouseAssistant(CreateUserWarehouseAssistantDto createUserWarehouseAssistantDto);
}
