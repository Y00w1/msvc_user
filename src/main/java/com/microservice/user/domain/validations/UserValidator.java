package com.microservice.user.domain.validations;

import com.microservice.user.domain.constants.user.UserValidationConstants;
import com.microservice.user.domain.exceptions.user.InvalidEmailException;
import com.microservice.user.domain.exceptions.user.InvalidPhoneException;
import com.microservice.user.domain.exceptions.user.UserUnderageException;
import com.microservice.user.domain.models.User;

import java.time.LocalDate;

public class UserValidator {

    public void validate(User user) {
        validateAge(user.getBirthDate());
        validateEmail(user.getEmail());
        validatePhone(user.getPhone());
    }

    private void validateAge(LocalDate birthDate) {
        if (birthDate.isAfter(LocalDate.now().minusYears(UserValidationConstants.MIN_AGE))) {
            throw new UserUnderageException();
        }
    }

    private void validateEmail(String email) {
        if (!email.matches(UserValidationConstants.EMAIL_REGEX)) {
            throw new InvalidEmailException();
        }
    }

    private void validatePhone(String phone) {
        if (!phone.matches(UserValidationConstants.PHONE_REGEX)) {
            throw new InvalidPhoneException();
        }
    }
}
