package com.project.bookstore.application.port.in;

import com.project.bookstore.domain.model.Book;

import java.util.List;

public interface GetBookPort {
    List<Book> findAll();
    Book findById(Long id);

    List<Book> findByTitle(String title);
    List<Book> findByAuthorName(String authorName);
    List<Book> findByCategoryName(String categoryName);
    List<Book> findByPublisherName(String publisherName);
}
