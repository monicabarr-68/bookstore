package com.project.bookstore.application.service;

import com.project.bookstore.application.port.in.CreateBookCommand;
import com.project.bookstore.application.port.in.GetAuthorPort;
import com.project.bookstore.application.port.in.GetPublisherPort;
import com.project.bookstore.application.port.out.BookRepositoryPort;
import com.project.bookstore.domain.model.Author;
import com.project.bookstore.domain.model.Book;
import com.project.bookstore.domain.model.BookPublisher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    BookRepositoryPort bookRepository;

    @Mock
    GetPublisherPort publisherPort;

    @Mock
    GetAuthorPort authorPort;

    @InjectMocks
    BookService bookService;

    @Test
    void shouldSaveBookOnce(){
        BookPublisher publisher = new BookPublisher(1L,"Editorial Planeta", "www.planeta.com");
        Author author = new Author(1L, "Marcos Avilés", "Biografía del autor" );
        List<Author> authorList = new ArrayList<>();
        authorList.add(author);

        Book book = new Book(
                "De dónde venimos los cholos",
                35.5, 8, 120, 2018,
                publisher,
                authorList);

        when(publisherPort.findById(1L)).thenReturn(publisher);
        when(authorPort.findById(1L)).thenReturn(author);
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        bookService.create(new CreateBookCommand("De dónde venimos los cholos",
                35.5, 8, 120, 2018,
                1L, authorList.stream().map(Author::getId).toList()));

        verify(bookRepository, times(1)).save(any(Book.class));

    }


}
