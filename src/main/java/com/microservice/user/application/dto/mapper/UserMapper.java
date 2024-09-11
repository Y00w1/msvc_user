package com.microservice.user.application.dto.mapper;

import com.microservice.user.application.dto.user.CreateUserWarehouseAssistantDto;
import com.microservice.user.application.dto.user.UserDto;
import com.microservice.user.domain.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {
    User toDomain(UserDto userDto);
    User toDomain(CreateUserWarehouseAssistantDto createUserWarehouseAssistantDto);
    UserDto toDto(User user);
}
