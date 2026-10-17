package com.project.bookstore.application.service;

import com.project.bookstore.application.port.in.CreateBookCommand;
import com.project.bookstore.application.port.in.CreateBookPort;
import com.project.bookstore.application.port.in.GetAuthorPort;
import com.project.bookstore.application.port.in.GetPublisherPort;

import com.project.bookstore.application.port.out.BookRepositoryPort;

import com.project.bookstore.domain.model.Author;
import com.project.bookstore.domain.model.Book;
import com.project.bookstore.domain.model.BookPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.stream;

@Service
public class BookService implements CreateBookPort {

    private final BookRepositoryPort bookRepositoryPort;
    private final GetPublisherPort publisherPort;
    private final GetAuthorPort authorPort;

    public BookService(BookRepositoryPort bookRepositoryPort,
                       GetPublisherPort publisherPort,
                       GetAuthorPort authorPort
                       ){
        this.bookRepositoryPort=bookRepositoryPort;
        this.publisherPort = publisherPort;
        this.authorPort = authorPort;
    }

    @Override
    public Book create(CreateBookCommand bookCommand) {
        //Obtiene el objeto publisher a partir del id del comando y con ayuda del metodo finBYId() del puerto
        BookPublisher publisher = publisherPort.findById(bookCommand.publisherId());

        //Obtiene la lista de autores a partir de la lista de ids del comando. Se aprovecha la programación funcional para trabajar con las listas
        List<Author> authors = bookCommand.authorsId()
                                          .stream()
                                          .map(authorPort::findById)
                                          .filter(Objects::nonNull)
                                          .toList();

        Book book = new Book(
                bookCommand.title(),
                bookCommand.price(),
                bookCommand.stock(),
                bookCommand.numberPages(),
                bookCommand.publicationYear(),
                publisher,
                authors);

        return bookRepositoryPort.save(book);
    }
}
