package com.example.server.utils;

import com.example.server.entity.AuthorEntity;
import com.example.server.exception.ValidationExceptionAuthor;

public class AuthorValidationUtils {
    public static void authorValidationUtils(AuthorEntity author) throws ValidationExceptionAuthor{
        String name = author.getName();
        if(name == null || name.isBlank()){
            throw new ValidationExceptionAuthor("Поле имени не может быть пустым");
        }
    }
}
