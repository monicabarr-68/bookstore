package com.project.bookstore.application.port.out;

import com.project.bookstore.domain.model.BookPublisher;

import java.util.List;
import java.util.Optional;

public interface PublisherRepositoryPort {
    BookPublisher save(BookPublisher publisher);
    List<BookPublisher> findAllPublishers();
    Optional<BookPublisher> findById(Long id);
    void deletePublisher(Long id);

}
