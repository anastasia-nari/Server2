package com.example.server.utils;

import com.example.server.entity.BookEntity;
import com.example.server.exception.ValidationException;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

public class ValidationUtils {
    public static void validateBook (BookEntity book) throws ValidationException {
        String title= book.getTitle();
        if (title == null || title.isBlank()
        || title.length()<3)
            throw new ValidationException("Название должно быть больше трех букв");
    }
}
