package com.microservice.user.domain.validations;

import com.microservice.user.domain.constants.user.UserValidationConstants;
import com.microservice.user.domain.exceptions.user.InvalidEmailException;
import com.microservice.user.domain.exceptions.user.InvalidPhoneException;
import com.microservice.user.domain.exceptions.user.UserUnderageException;
import com.microservice.user.domain.models.User;

import java.time.LocalDate;

/**
 * Validator class for validating user details.
 * This class provides methods to validate the age, email, and phone number of a user.
 */
public class UserValidator {

    /**
     * Validates the user details.
     * This method is used in the use case implementation to validate the user information before being created.
     *
     * @param user the user to validate
     * @throws UserUnderageException if the user is underage
     * @throws InvalidEmailException if the email is invalid
     * @throws InvalidPhoneException if the phone number is invalid
     */
    public void validate(User user) {
        validateAge(user.getBirthDate());
        validateEmail(user.getEmail());
        validatePhone(user.getPhone());
    }

    /**
     * Validates the user's age.
     * This method checks if the user's birth date indicates that they are at least the minimum required age.
     *
     * @param birthDate the birth date of the user
     * @throws UserUnderageException if the user is underage
     */
    private void validateAge(LocalDate birthDate) {
        if (birthDate.isAfter(LocalDate.now().minusYears(UserValidationConstants.MIN_AGE))) {
            throw new UserUnderageException();
        }
    }

    /**
     * Validates the user's email.
     * This method checks if the user's email matches the required email pattern.
     *
     * @param email the email of the user
     * @throws InvalidEmailException if the email is invalid
     */
    private void validateEmail(String email) {
        if (!email.matches(UserValidationConstants.EMAIL_REGEX)) {
            throw new InvalidEmailException();
        }
    }

    /**
     * Validates the user's phone number.
     * This method checks if the user's phone number matches the required phone number pattern.
     *
     * @param phone the phone number of the user
     * @throws InvalidPhoneException if the phone number is invalid
     */
    private void validatePhone(String phone) {
        if (!phone.matches(UserValidationConstants.PHONE_REGEX)) {
            throw new InvalidPhoneException();
        }
    }
}
