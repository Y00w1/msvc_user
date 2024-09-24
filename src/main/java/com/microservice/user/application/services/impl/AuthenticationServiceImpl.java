package com.microservice.user.application.services.impl;

import com.microservice.user.application.dto.authentication.AuthRespDto;
import com.microservice.user.application.dto.authentication.LoginReqDto;
import com.microservice.user.application.dto.authentication.SignupReqDto;
import com.microservice.user.application.dto.mapper.AuthenticationMapper;
import com.microservice.user.application.services.AuthenticationService;
import com.microservice.user.domain.ports.in.AuthenticationUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationUseCase authenticationUseCase;
    private final AuthenticationMapper mapper;

    @Override
    public AuthRespDto login(LoginReqDto loginReqDto) {
        return mapper.toDto(authenticationUseCase.login(loginReqDto.email(), loginReqDto.password()));
    }

    @Override
    public AuthRespDto signup(SignupReqDto signupReqDto) {
        return mapper.toDto(authenticationUseCase.signup(mapper.toDomain(signupReqDto)));
    }
}
