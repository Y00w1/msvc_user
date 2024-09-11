package com.microservice.user.domain.ports.out.user;

import com.microservice.user.domain.models.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User createUser(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findByIdDocument(String idDocument);
}
