package com.example.server.servise;

import com.example.server.entity.BookEntity;
import com.example.server.exception.ValidationExceptionBook;
import com.example.server.repo.BookRepo;
import com.example.server.utils.BookValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo repo;
    public BookService(BookRepo repo){
        this.repo =repo;
    }

    public Iterable<BookEntity> getAll(){return repo.findAll();}
    public Iterable<BookEntity> getTitle(String title){
        return repo.findDistinctByTitle(title);}
    public BookEntity save(BookEntity book) throws ValidationExceptionBook {
        BookValidationUtils.bookValidationUtils(book);
        return repo.save(book);}
    public void delete(Long id){repo.deleteById(id);}

    public BookEntity find(Long id){return  repo.findById(id).get();}

}
