package com.project.bookstore.infraestructure.adapter.out.adapater;

import com.project.bookstore.application.port.out.PublisherRepositoryPort;
import com.project.bookstore.domain.model.BookPublisher;
import com.project.bookstore.infraestructure.adapter.out.mappers.BookPublisherPersistanceMapper;
import com.project.bookstore.infraestructure.adapter.out.repository.BookPublisherJpaRepository;
import com.project.bookstore.infraestructure.entities.BookPublisherEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookPublisherPersistanceAdapter implements PublisherRepositoryPort {

    private final BookPublisherJpaRepository publisherJpaRepository;

    public BookPublisherPersistanceAdapter(BookPublisherJpaRepository publisherJpaRepository){
        this.publisherJpaRepository = publisherJpaRepository;
    }

    @Override
    public BookPublisher save(BookPublisher publisher) {
        BookPublisherEntity entitySaved = publisherJpaRepository.save(BookPublisherPersistanceMapper.toPublisherEntity(publisher));
        return BookPublisherPersistanceMapper.toPublisher(entitySaved);
    }

    @Override
    public List<BookPublisher> findAllPublishers() {
        return publisherJpaRepository.findAll()
                                     .stream()
                                     .map(publisherEntity -> BookPublisherPersistanceMapper.toPublisher(publisherEntity))
                                     .toList();
    }

    @Override
    public Optional<BookPublisher> findById(Long id) {
        return publisherJpaRepository.findById(id)
                                     .map(publisherEntity -> BookPublisherPersistanceMapper.toPublisher(publisherEntity) );
    }

    @Override
    public void deletePublisher(Long id) {
        publisherJpaRepository.deleteById(id);
    }
}
