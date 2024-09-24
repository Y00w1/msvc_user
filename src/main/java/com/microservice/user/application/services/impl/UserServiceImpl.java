package com.microservice.user.application.services.impl;

import com.microservice.user.application.dto.mapper.UserMapper;
import com.microservice.user.application.dto.user.CreateUserDto;
import com.microservice.user.application.dto.user.UserDto;
import com.microservice.user.application.services.UserService;
import com.microservice.user.domain.models.User;
import com.microservice.user.domain.ports.in.CreateWarehouseAssistantUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final CreateWarehouseAssistantUserUseCase createWarehouseAssistantUserUseCase;

    private final UserMapper userMapper;

    @Override
    public UserDto createWarehouseAssistant(CreateUserDto createUserDto) {
        User userToCreate = userMapper.toDomain(createUserDto);
        return userMapper.toDto(createWarehouseAssistantUserUseCase.createWarehouseAssistantUser(userToCreate));
    }
}
