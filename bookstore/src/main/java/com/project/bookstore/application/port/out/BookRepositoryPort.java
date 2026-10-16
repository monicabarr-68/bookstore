package com.project.bookstore.application.port.out;

import com.project.bookstore.domain.model.Book;

public interface BookRepositoryPort {
    Book save(Book book);
}
