package com.project.bookstore.infraestructure.adapter.out.mappers;

import com.project.bookstore.domain.model.BookPublisher;
import com.project.bookstore.infraestructure.entities.BookPublisherEntity;

public class BookPublisherPersistanceMapper {

    public static BookPublisherEntity toPublisherEntity(BookPublisher publisher){
        return new BookPublisherEntity(publisher.getId(),
                                       publisher.getName(),
                                       publisher.getWebsite());
    }

    public static BookPublisher toPublisher(BookPublisherEntity publisherEntity){
        return new BookPublisher(publisherEntity.getId(),
                                 publisherEntity.getName(),
                                 publisherEntity.getWebsite());
    }
}
