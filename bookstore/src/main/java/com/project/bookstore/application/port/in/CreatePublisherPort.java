package com.project.bookstore.application.port.in;

import com.project.bookstore.domain.model.BookPublisher;

public interface CreatePublisherPort {
    BookPublisher create(CreatePublisherCommand publisherCommand);
}
