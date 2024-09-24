package com.microservice.user.application.dto.authentication;

public record AuthRespDto(
        String token,
        Long id,
        String email,
        String role
) {
}
