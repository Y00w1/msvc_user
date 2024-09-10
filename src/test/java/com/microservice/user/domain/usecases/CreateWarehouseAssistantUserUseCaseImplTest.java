package com.microservice.user.domain.usecases;

import com.microservice.user.domain.constants.role.RoleConstants;
import com.microservice.user.domain.exceptions.role.RoleNotFoundException;
import com.microservice.user.domain.exceptions.user.DuplicateEmailException;
import com.microservice.user.domain.exceptions.user.DuplicateIdDocumentException;
import com.microservice.user.domain.models.Role;
import com.microservice.user.domain.models.User;
import com.microservice.user.domain.ports.out.role.RoleRepositoryPort;
import com.microservice.user.domain.ports.out.user.UserRepositoryPort;
import com.microservice.user.domain.validations.UserValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateWarehouseAssistantUserUseCaseImplTest {
    @Mock
    private UserRepositoryPort userRepositoryPort;

    @Mock
    private RoleRepositoryPort roleRepositoryPort;

    @Mock
    private UserValidator userValidator;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private CreateWarehouseAssistantUserUseCaseImpl createWarehouseAssistantUserUseCase;

    @Test
    void createWarehouseAssistantUser_Success() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setIdDocument("123456");
        user.setPassword("password");

        when(userRepositoryPort.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(userRepositoryPort.findByIdDocument(user.getIdDocument())).thenReturn(Optional.empty());
        when(roleRepositoryPort.findRoleByName(RoleConstants.WAREHOUSE_ASSISTANT)).thenReturn(Optional.of(new Role()));
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");
        when(userRepositoryPort.createUser(any(User.class))).thenReturn(user);

        User createdUser = createWarehouseAssistantUserUseCase.createWarehouseAssistantUser(user);

        assertNotNull(createdUser);
        verify(userValidator).validate(user);
        verify(userRepositoryPort).findByEmail(user.getEmail());
        verify(userRepositoryPort).findByIdDocument(user.getIdDocument());
        verify(roleRepositoryPort).findRoleByName(RoleConstants.WAREHOUSE_ASSISTANT);
        verify(passwordEncoder).encode("password");
        verify(userRepositoryPort).createUser(user);
    }

    @Test
    void createWarehouseAssistantUser_DuplicateEmailException() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setIdDocument("123456");

        when(userRepositoryPort.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        DuplicateEmailException exception = assertThrows(DuplicateEmailException.class, () -> {
            createWarehouseAssistantUserUseCase.createWarehouseAssistantUser(user);
        });

        assertEquals("Email already in use: test@example.com", exception.getMessage());
        verify(userRepositoryPort).findByEmail(user.getEmail());
        verify(userRepositoryPort, never()).findByIdDocument(anyString());
        verify(roleRepositoryPort, never()).findRoleByName(anyString());
        verify(passwordEncoder, never()).encode(anyString());
        verify(userRepositoryPort, never()).createUser(any(User.class));
    }

    @Test
    void createWarehouseAssistantUser_DuplicateIdDocumentException() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setIdDocument("123456");

        when(userRepositoryPort.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(userRepositoryPort.findByIdDocument(user.getIdDocument())).thenReturn(Optional.of(user));

        DuplicateIdDocumentException exception = assertThrows(DuplicateIdDocumentException.class, () -> {
            createWarehouseAssistantUserUseCase.createWarehouseAssistantUser(user);
        });

        assertEquals("ID Document already in use: 123456", exception.getMessage());
        verify(userRepositoryPort).findByEmail(user.getEmail());
        verify(userRepositoryPort).findByIdDocument(user.getIdDocument());
        verify(roleRepositoryPort, never()).findRoleByName(anyString());
        verify(passwordEncoder, never()).encode(anyString());
        verify(userRepositoryPort, never()).createUser(any(User.class));
    }

    @Test
    void createWarehouseAssistantUser_RoleNotFoundException() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setIdDocument("123456");

        when(userRepositoryPort.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(userRepositoryPort.findByIdDocument(user.getIdDocument())).thenReturn(Optional.empty());
        when(roleRepositoryPort.findRoleByName(RoleConstants.WAREHOUSE_ASSISTANT)).thenReturn(Optional.empty());

        RoleNotFoundException exception = assertThrows(RoleNotFoundException.class, () -> {
            createWarehouseAssistantUserUseCase.createWarehouseAssistantUser(user);
        });

        assertEquals("Role not found", exception.getMessage());
        verify(userRepositoryPort).findByEmail(user.getEmail());
        verify(userRepositoryPort).findByIdDocument(user.getIdDocument());
        verify(roleRepositoryPort).findRoleByName(RoleConstants.WAREHOUSE_ASSISTANT);
        verify(passwordEncoder, never()).encode(anyString());
        verify(userRepositoryPort, never()).createUser(any(User.class));
    }
}