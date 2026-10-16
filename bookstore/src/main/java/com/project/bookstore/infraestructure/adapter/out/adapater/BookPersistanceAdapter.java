package com.project.bookstore.infraestructure.adapter.out.adapater;

import com.project.bookstore.application.port.out.BookRepositoryPort;
import com.project.bookstore.domain.model.Book;
import com.project.bookstore.infraestructure.adapter.out.mappers.AuthorPersistanceMapper;
import com.project.bookstore.infraestructure.adapter.out.mappers.BookPublisherPersistanceMapper;
import com.project.bookstore.infraestructure.adapter.out.mappers.CategoryBookPersistanceMapper;
import com.project.bookstore.infraestructure.adapter.out.repository.BookJpaRepository;
import com.project.bookstore.infraestructure.entities.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookPersistanceAdapter implements BookRepositoryPort {

    private final BookJpaRepository bookJpaRepository;

    public BookPersistanceAdapter(BookJpaRepository bookJpaRepository){
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    public Book save(Book book) {
        return toDomain(bookJpaRepository.save(toEntity(book)));
    }


    private static BookEntity toEntity(Book b){
        return new BookEntity(b.getId(),
                b.getTitle(),
                b.getPrice(),
                b.getStock(),
                b.getIsbn(),
                b.getSynopsis(),
                b.getNumberPages(),
                b.getPublicationYear(),
                BookPublisherPersistanceMapper.toPublisherEntity(b.getPublisher()),
                b.getAuthors().stream().map(AuthorPersistanceMapper::toAuthorEntity).toList(),
                b.getCategories().stream().map(CategoryBookPersistanceMapper::toCategoryBookEntity).toList());
    }

    private static Book toDomain(BookEntity e){
        return new Book(e.getId(),
                e.getTitle(),
                e.getPrice(),
                e.getStock(),
                e.getIsbn(),
                e.getSynopsis(),
                e.getNumberPages(),
                e.getPublicationYear(),
                BookPublisherPersistanceMapper.toPublisher(e.getPublisher()),
                e.getAuthors().stream().map(AuthorPersistanceMapper::toAuthor).toList(),
                e.getCategories().stream().map(CategoryBookPersistanceMapper::toCategoryBook).toList()
                );
    }
}
