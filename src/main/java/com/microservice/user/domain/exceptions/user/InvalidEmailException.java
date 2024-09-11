package com.microservice.user.domain.exceptions.user;

import com.microservice.user.domain.constants.user.UserValidationConstants;
import com.microservice.user.domain.exceptions.DomainException;
import org.springframework.http.HttpStatus;

public class InvalidEmailException extends DomainException {
    public InvalidEmailException() {
        super(UserValidationConstants.INVALID_EMAIL_MESSAGE, HttpStatus.BAD_REQUEST);
    }
}
