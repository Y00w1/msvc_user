package com.microservice.user.application.constants.user;

public class UserValidationConstants {
    public static final int NAME_MIN_LENGTH = 2;
    public static final int NAME_MAX_LENGTH = 50;
    public static final int PHONE_MAX_LENGTH = 13;
    public static final int ID_DOCUMENT_MAX_LENGTH = 20;
    public static final String PHONE_REGEX = "^\\+?[0-9]{7,13}$";
    public static final String EMAIL_REGEX = "^(.+)@(\\S+)$";
    public static final String ID_DOCUMENT_REGEX = "^[0-9]+$";
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$";
    public static final int PASSWORD_MIN_LENGTH = 8;
}
