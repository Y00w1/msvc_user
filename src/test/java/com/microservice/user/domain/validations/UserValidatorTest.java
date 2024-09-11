package com.microservice.user.domain.validations;

import com.microservice.user.domain.exceptions.user.InvalidEmailException;
import com.microservice.user.domain.exceptions.user.InvalidPhoneException;
import com.microservice.user.domain.exceptions.user.UserUnderageException;
import com.microservice.user.domain.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserValidatorTest {
    private UserValidator userValidator;

    @BeforeEach
    void setUp() {
        userValidator = new UserValidator();
    }

    @Test
    void validate_ValidUser() {
        User user = new User();
        user.setBirthDate(LocalDate.now().minusYears(20));
        user.setEmail("valid.email@example.com");
        user.setPhone("1234567890");

        userValidator.validate(user);
    }

    @Test
    void validate_UserUnderageException() {
        User user = new User();
        user.setBirthDate(LocalDate.now().minusYears(10));

        assertThrows(UserUnderageException.class, () -> userValidator.validate(user));
    }

    @Test
    void validate_InvalidEmailException() {
        User user = new User();
        user.setBirthDate(LocalDate.now().minusYears(20));
        user.setEmail("invalid-email");

        assertThrows(InvalidEmailException.class, () -> userValidator.validate(user));
    }

    @Test
    void validate_InvalidPhoneException() {
        User user = new User();
        user.setBirthDate(LocalDate.now().minusYears(20));
        user.setEmail("valid.email@example.com");
        user.setPhone("invalid-phone");

        assertThrows(InvalidPhoneException.class, () -> userValidator.validate(user));
    }
}