package com.microservice.user.domain.ports.in;

import com.microservice.user.domain.models.AuthResp;
import com.microservice.user.domain.models.User;

public interface AuthenticationUseCase {
    AuthResp login(String email, String password);
    AuthResp signup(User user);
}
