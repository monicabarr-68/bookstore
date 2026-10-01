package com.project.bookstore.application.port.out;

import com.project.bookstore.domain.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepositoryPort {
    Author save(Author author);
    List<Author> findAllAuthors();
    Optional<Author> findById(Long id);
    void deleteAuthor(Long id);
}
