package com.example.server.utils;

import com.example.server.entity.BookEntity;
import com.example.server.exception.ValidationExceptionBook;

public class BookValidationUtils {
    public static void bookValidationUtils(BookEntity book) {
        String title =book.getTitle();
        if(title == null || title.isBlank()){
            throw new ValidationExceptionBook("Поле название не может быть пустым");
        }
        if (book.getAuthor()==null){
            throw new ValidationExceptionBook("Нужно выбрать автора");
        }
        if(book.getPublishing()==null){
            throw new ValidationExceptionBook("Нужно выбрать издательство");
        }
    }
}
