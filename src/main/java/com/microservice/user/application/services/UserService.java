package com.microservice.user.application.services;

import com.microservice.user.application.dto.user.CreateUserDto;
import com.microservice.user.application.dto.user.UserDto;

public interface UserService {
    UserDto createWarehouseAssistant(CreateUserDto createUserDto);
}
