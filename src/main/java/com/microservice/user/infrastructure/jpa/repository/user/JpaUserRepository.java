package com.microservice.user.infrastructure.jpa.repository.user;

import com.microservice.user.infrastructure.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByIdDocument(String idDocument);
}
