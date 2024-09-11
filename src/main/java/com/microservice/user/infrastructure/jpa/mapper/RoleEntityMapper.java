package com.microservice.user.infrastructure.jpa.mapper;

import com.microservice.user.domain.models.Role;
import com.microservice.user.infrastructure.jpa.entities.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {
    RoleEntity toEntity(Role role);
    Role toDomain(RoleEntity role);
}
