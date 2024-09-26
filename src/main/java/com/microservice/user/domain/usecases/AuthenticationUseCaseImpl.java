package com.microservice.user.domain.usecases;

import com.microservice.user.domain.models.AuthResp;
import com.microservice.user.domain.models.User;
import com.microservice.user.domain.ports.in.AuthenticationUseCase;
import com.microservice.user.domain.ports.out.user.UserRepositoryPort;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationUseCaseImpl implements AuthenticationUseCase {

    @Override
    public AuthResp login(String email, String password) {
        return null;
    }

    @Override
    public AuthResp signup(User user) {
        return null;
    }
}
