package com.project.bookstore.application.port.in;

import com.project.bookstore.domain.model.Author;

import java.util.List;

public interface GetAuthorPort {

    List<Author> findAllAuthors();
    Author findById(Long id);

}
