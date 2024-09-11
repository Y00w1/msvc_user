package com.microservice.user.application.services;

import com.microservice.user.application.dto.mapper.UserMapper;
import com.microservice.user.application.dto.user.CreateUserWarehouseAssistantDto;
import com.microservice.user.application.dto.user.UserDto;
import com.microservice.user.domain.models.User;
import com.microservice.user.domain.ports.in.CreateWarehouseAssistantUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final CreateWarehouseAssistantUserUseCase createWarehouseAssistantUserUseCase;

    private final UserMapper userMapper;

    @Override
    public UserDto createWarehouseAssistant(CreateUserWarehouseAssistantDto createUserWarehouseAssistantDto) {
        User userToCreate = userMapper.toDomain(createUserWarehouseAssistantDto);
        return userMapper.toDto(createWarehouseAssistantUserUseCase.createWarehouseAssistantUser(userToCreate));
    }
}
