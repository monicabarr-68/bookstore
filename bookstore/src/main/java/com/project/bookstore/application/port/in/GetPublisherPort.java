package com.project.bookstore.application.port.in;

import com.project.bookstore.domain.model.BookPublisher;

import java.util.List;

public interface GetPublisherPort {

    List<BookPublisher> findAllPublishers();
    BookPublisher findById(Long id);
}
