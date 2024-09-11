package com.microservice.user.infrastructure.jpa.repository.user;

import com.microservice.user.domain.models.User;
import com.microservice.user.domain.ports.out.user.UserRepositoryPort;
import com.microservice.user.infrastructure.jpa.entities.UserEntity;
import com.microservice.user.infrastructure.jpa.mapper.UserEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaUserRepositoryAdapter implements UserRepositoryPort {
    private final JpaUserRepository jpaUserRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User createUser(User user) {
        UserEntity userToCreate = userEntityMapper.toEntity(user);
        return userEntityMapper.toDomain(jpaUserRepository.save(userToCreate));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email).map(userEntityMapper::toDomain);
    }

    @Override
    public Optional<User> findByIdDocument(String idDocument) {
        return jpaUserRepository.findByIdDocument(idDocument).map(userEntityMapper::toDomain);
    }
}
