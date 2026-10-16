package com.project.bookstore.application.port.in;

import com.project.bookstore.domain.model.Book;

public interface CreateBookPort {
    Book create(CreateBookCommand bookCommand);
}
