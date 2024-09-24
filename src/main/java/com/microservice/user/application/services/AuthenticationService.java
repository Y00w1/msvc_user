package com.microservice.user.application.services;

import com.microservice.user.application.dto.authentication.AuthRespDto;
import com.microservice.user.application.dto.authentication.LoginReqDto;
import com.microservice.user.application.dto.authentication.SignupReqDto;

public interface AuthenticationService {
    AuthRespDto login(LoginReqDto loginReqDto);
    AuthRespDto signup(SignupReqDto signupReqDto);
}
