package com.microservice.user.application.constants.user;

public class UserValidationMessages {
    public static final String NAME_NOT_BLANK = "Name is required";
    public static final String NAME_SIZE = "Name must be between {min} and {max} characters";
    public static final String LAST_NAME_NOT_BLANK = "Last name is required";
    public static final String LAST_NAME_SIZE = "Last name must be between {min} and {max} characters";

    public static final String ID_DOCUMENT_NOT_BLANK = "ID document is required";
    public static final String ID_DOCUMENT_NUMERIC = "ID document must be numeric";

    public static final String PHONE_NOT_BLANK = "Phone number is required";
    public static final String PHONE_SIZE = "Phone number must not exceed {max} characters";
    public static final String PHONE_PATTERN = "Phone number must be a valid format (e.g., +573005698325)";

    public static final String BIRTH_DATE_NOT_NULL = "Birth date is required";
    public static final String BIRTH_DATE_PAST = "Birth date must be a past date";

    public static final String EMAIL_NOT_BLANK = "Email is required";
    public static final String EMAIL_PATTERN = "Email must be a valid format (e.g., example@domain.com)";

    public static final String PASSWORD_NOT_BLANK = "Password is required";
    public static final String PASSWORD_SIZE = "Password must be at least {min} characters long";
    public static final String PASSWORD_COMPLEXITY = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character";
    public static final String ID_DOCUMENT_SIZE = "ID document must not exceed {max} characters";
}
