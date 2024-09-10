package com.microservice.user.domain.constants.user;

public class UserValidationConstants {
    public static final String INVALID_EMAIL_MESSAGE = "Invalid email format";
    public static final String INVALID_PHONE_MESSAGE = "Invalid phone number format";
    public static final String UNDERAGE_MESSAGE = "User must be at least 18 years old";
    public static final String DUPLICATE_EMAIL_MESSAGE = "Email already in use: ";
    public static final String DUPLICATE_ID_DOCUMENT_MESSAGE = "ID Document already in use: ";

    public static final String EMAIL_REGEX = "[^@\\s]+@[^@\\s]+\\.[^@\\s]+";
    public static final String PHONE_REGEX = "\\+?\\d{1,13}";
    public static final int MIN_AGE = 18;
}
