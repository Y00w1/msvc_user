package com.microservice.user.domain.ports.in;

import com.microservice.user.application.dto.user.CreateUserDto;
import com.microservice.user.domain.models.User;

public interface UserFactory {
    User createUser(User user, String roleName);
}
