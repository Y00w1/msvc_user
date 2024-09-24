package com.microservice.user.application.dto.authentication;

import com.microservice.user.application.constants.user.UserValidationConstants;
import com.microservice.user.application.constants.user.UserValidationMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginReqDto(
        @NotBlank(message = UserValidationMessages.EMAIL_NOT_BLANK)
        @Email(regexp = UserValidationConstants.EMAIL_REGEX, message = UserValidationMessages.EMAIL_PATTERN)
        String email,
        @NotBlank(message = UserValidationMessages.PASSWORD_NOT_BLANK)
        String password
) {
}
