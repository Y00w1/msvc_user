package com.microservice.user.application.dto.user;

import com.microservice.user.application.dto.role.RoleDto;

public record UserDto(
        String name,
        String email,
        RoleDto role
) {
}
