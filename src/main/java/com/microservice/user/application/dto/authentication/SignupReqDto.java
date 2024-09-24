package com.microservice.user.application.dto.authentication;

import com.microservice.user.application.constants.user.UserValidationConstants;
import com.microservice.user.application.constants.user.UserValidationMessages;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record SignupReqDto(
        @NotBlank(message = UserValidationMessages.NAME_NOT_BLANK)
        @Size(min = UserValidationConstants.NAME_MIN_LENGTH, max = UserValidationConstants.NAME_MAX_LENGTH,
                message = UserValidationMessages.NAME_SIZE)
        String name,

        @NotBlank(message = UserValidationMessages.LAST_NAME_NOT_BLANK)
        @Size(min = UserValidationConstants.NAME_MIN_LENGTH, max = UserValidationConstants.NAME_MAX_LENGTH,
                message = UserValidationMessages.LAST_NAME_SIZE)
        String lastName,

        @NotBlank(message = UserValidationMessages.ID_DOCUMENT_NOT_BLANK)
        @Size(max = UserValidationConstants.ID_DOCUMENT_MAX_LENGTH, message = UserValidationMessages.ID_DOCUMENT_SIZE)
        @Pattern(regexp = UserValidationConstants.ID_DOCUMENT_REGEX, message = UserValidationMessages.ID_DOCUMENT_NUMERIC)
        String idDocument,

        @NotBlank(message = UserValidationMessages.PHONE_NOT_BLANK)
        @Size(max = UserValidationConstants.PHONE_MAX_LENGTH, message = UserValidationMessages.PHONE_SIZE)
        @Pattern(regexp = UserValidationConstants.PHONE_REGEX, message = UserValidationMessages.PHONE_PATTERN)
        String phone,

        @NotNull(message = UserValidationMessages.BIRTH_DATE_NOT_NULL)
        @Past(message = UserValidationMessages.BIRTH_DATE_PAST)
        LocalDate birthDate,

        @NotBlank(message = UserValidationMessages.EMAIL_NOT_BLANK)
        @Email(regexp = UserValidationConstants.EMAIL_REGEX, message = UserValidationMessages.EMAIL_PATTERN)
        String email,

        @NotBlank(message = UserValidationMessages.PASSWORD_NOT_BLANK)
        @Pattern(
                regexp = UserValidationConstants.PASSWORD_REGEX,
                message = UserValidationMessages.PASSWORD_COMPLEXITY
        )
        @Size(min = UserValidationConstants.PASSWORD_MIN_LENGTH, message = UserValidationMessages.PASSWORD_SIZE)
        String password
) {
}
