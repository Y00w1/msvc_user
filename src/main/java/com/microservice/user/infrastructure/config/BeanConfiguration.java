package com.microservice.user.infrastructure.config;

import com.microservice.user.domain.factory.UserFactoryImpl;
import com.microservice.user.domain.ports.in.AuthenticationUseCase;
import com.microservice.user.domain.ports.in.CreateWarehouseAssistantUserUseCase;
import com.microservice.user.domain.ports.in.UserFactory;
import com.microservice.user.domain.ports.out.role.RoleRepositoryPort;
import com.microservice.user.domain.ports.out.user.UserRepositoryPort;
import com.microservice.user.domain.usecases.AuthenticationUseCaseImpl;
import com.microservice.user.domain.usecases.CreateWarehouseAssistantUserUseCaseImpl;
import com.microservice.user.domain.validations.UserValidator;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class BeanConfiguration {
    private final UserRepositoryPort userRepositoryPort;
    private final RoleRepositoryPort roleRepositoryPort;

    @Bean
    public UserValidator userValidator() {
        return new UserValidator();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserFactory userFactory() {
        return new UserFactoryImpl(roleRepositoryPort, passwordEncoder());
    }

    @Bean
    public CreateWarehouseAssistantUserUseCase createWarehouseAssistantUserUseCase() {
        return new CreateWarehouseAssistantUserUseCaseImpl(userFactory(), userRepositoryPort, userValidator());
    }

    @Bean
    public AuthenticationUseCase authenticationUseCase(){
        return new AuthenticationUseCaseImpl();
    }
}
