package com.example.server.exception;

import javax.validation.ValidationException;

public class ValidationExceptionUser extends ValidationException {
    public ValidationExceptionUser(String message){
        super(message);
    }
}
