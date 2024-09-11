package com.microservice.user.application.dto.mapper;

import com.microservice.user.application.dto.role.RoleDto;
import com.microservice.user.domain.models.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toDomain(RoleDto role);
    RoleDto toDto(Role role);
}
