package com.microservice.user.domain.exceptions.user;

import com.microservice.user.domain.constants.user.UserValidationConstants;
import com.microservice.user.domain.exceptions.DomainException;
import org.springframework.http.HttpStatus;

public class DuplicateIdDocumentException extends DomainException {
    public DuplicateIdDocumentException(String idDocument) {
        super(UserValidationConstants.DUPLICATE_ID_DOCUMENT_MESSAGE + idDocument, HttpStatus.CONFLICT);
    }
}
