package com.microservice.user.application.dto.mapper;

import com.microservice.user.application.dto.authentication.AuthRespDto;
import com.microservice.user.application.dto.authentication.SignupReqDto;
import com.microservice.user.domain.models.AuthResp;
import com.microservice.user.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthenticationMapper {
    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "role", source = "user.role.name")
    AuthRespDto toDto(AuthResp authResp);
    User toDomain(SignupReqDto signupReqDto);
}
