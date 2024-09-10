package com.microservice.user.domain.exceptions.user;

import com.microservice.user.domain.constants.user.UserValidationConstants;
import com.microservice.user.domain.exceptions.DomainException;
import org.springframework.http.HttpStatus;

public class UserUnderageException extends DomainException {
    public UserUnderageException() {
        super(UserValidationConstants.UNDERAGE_MESSAGE, HttpStatus.BAD_REQUEST);
    }
}
