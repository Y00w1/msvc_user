package com.microservice.user.domain.exceptions.role;

import com.microservice.user.domain.constants.role.RoleConstants;
import com.microservice.user.domain.exceptions.DomainException;
import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends DomainException {
    public RoleNotFoundException() {
        super(RoleConstants.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
