package com.example.server.repo;

import com.example.server.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<BookEntity, Long> {
    Iterable<BookEntity> findDistinctByTitle(String title);
}
