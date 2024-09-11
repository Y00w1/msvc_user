package com.microservice.user.infrastructure.jpa.mapper;

import com.microservice.user.domain.models.User;
import com.microservice.user.infrastructure.jpa.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoleEntityMapper.class})
public interface UserEntityMapper {
    UserEntity toEntity(User user);
    User toDomain(UserEntity user);
}
