package com.project.bookstore.application.service;

import com.project.bookstore.application.port.in.CreatePublisherCommand;
import com.project.bookstore.application.port.in.CreatePublisherPort;
import com.project.bookstore.application.port.in.DeletePublisherPort;
import com.project.bookstore.application.port.in.GetPublisherPort;
import com.project.bookstore.application.port.out.PublisherRepositoryPort;
import com.project.bookstore.domain.exception.PublisherNotFoundException;
import com.project.bookstore.domain.model.BookPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookPublisherService implements CreatePublisherPort, GetPublisherPort, DeletePublisherPort {

    private final PublisherRepositoryPort publisherRepositoryPort;

    public BookPublisherService(PublisherRepositoryPort publisherRepositoryPort){
        this.publisherRepositoryPort = publisherRepositoryPort;
    }

    @Override
    public BookPublisher create(CreatePublisherCommand publisherCommand) {
        BookPublisher publisher = new BookPublisher(publisherCommand.getName(), publisherCommand.getWebsite());
        return publisherRepositoryPort.save(publisher);
    }

    @Override
    public List<BookPublisher> findAllPublishers() {
        return publisherRepositoryPort.findAllPublishers();
    }

    @Override
    public BookPublisher findById(Long id) {
        Optional<BookPublisher> publisherOptional = publisherRepositoryPort.findById(id);
       if (publisherOptional.isEmpty()){
           throw new PublisherNotFoundException("Editorial con id " + id + " no encontrada");
       } return publisherOptional.get();
    }

    @Override
    public void delete(Long id) {
        findById(id);
        publisherRepositoryPort.deletePublisher(id);
    }
}
