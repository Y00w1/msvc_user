package com.microservice.user.domain.exceptions.user;

import com.microservice.user.domain.constants.user.UserValidationConstants;
import com.microservice.user.domain.exceptions.DomainException;
import org.springframework.http.HttpStatus;

public class InvalidPhoneException extends DomainException {
    public InvalidPhoneException() {
        super(UserValidationConstants.INVALID_PHONE_MESSAGE, HttpStatus.BAD_REQUEST);
    }
}
