package com.project.bookstore.infraestructure.adapter.in.controller;

import com.project.bookstore.application.port.in.CreateBookCommand;
import com.project.bookstore.application.port.in.CreateBookPort;
import com.project.bookstore.domain.model.Author;
import com.project.bookstore.domain.model.Book;
import com.project.bookstore.infraestructure.adapter.in.dtos.BookRequestDto;
import com.project.bookstore.infraestructure.adapter.in.dtos.BookResponseDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final CreateBookPort createBookPort;

    public BookController(CreateBookPort createBookPort){
        this.createBookPort=createBookPort;
    }

    @PostMapping
    BookResponseDto create(@Valid @RequestBody BookRequestDto request){
        return toResponse(createBookPort.create(toCommand(request)));
    }


    //Mappers
    private static CreateBookCommand toCommand(BookRequestDto request){
        return new CreateBookCommand(
                request.title(),
                request.price(),
                request.stock(),
                request.numberPages(),
                request.publicationYear(),
                request.publisherId(),
                request.authorsId()
                );
    }

    private static BookResponseDto toResponse(Book book){
        return new BookResponseDto(
                book.getId(),
                book.getTitle(),
                book.getPrice(),
                book.getPublicationYear(),
                book.getPublisher().getName(),//Se obtiene solo el nombre de la editorial
                book.getAuthors().stream().map(Author::getFullName).toList()//La lista de autores se mapea a una lista String de nombres
                );
    }
}
