package com.microservice.user.domain.exceptions.user;

import com.microservice.user.domain.constants.user.UserValidationConstants;
import com.microservice.user.domain.exceptions.DomainException;
import org.springframework.http.HttpStatus;

public class DuplicateEmailException extends DomainException {
    public DuplicateEmailException(String email) {
        super(UserValidationConstants.DUPLICATE_EMAIL_MESSAGE + email, HttpStatus.CONFLICT);
    }
}
