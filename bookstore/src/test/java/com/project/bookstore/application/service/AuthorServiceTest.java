package com.project.bookstore.application.service;

import com.project.bookstore.application.port.in.CreateAuthorCommand;
import com.project.bookstore.application.port.out.AuthorRepositoryPort;
import com.project.bookstore.domain.exception.AuthorNotFoundException;
import com.project.bookstore.domain.model.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    @Mock
    AuthorRepositoryPort repositoryPort;

    @InjectMocks
    AuthorService authorService;

    @Test
    void shouldThrowWhenAuthorNotExists(){
        when(repositoryPort.findById(40L))
                .thenReturn(Optional.empty());

        assertThrows(AuthorNotFoundException.class,
                () -> authorService.findById(40L));

    }

    @Test
    void shouldReturnAuthorIfExists(){

        Long authorId = 25L;
        Author author = new Author(authorId, "Marco Avilés",
                "Cholo. Serrano. Inmigrante. Nació en la ciudad de Abancay, creció en San Juan de Lurigancho, ilustre barrio de inmigrantes;");

        when(repositoryPort.findById(authorId)).thenReturn(Optional.of(author));

        Author testAuthor = authorService.findById(authorId);

        assertNotNull(testAuthor);
        assertNotNull(testAuthor.getId());
        assertEquals("Marco Avilés",testAuthor.getFullName());

        verify(repositoryPort).findById(eq(authorId));
        verify(repositoryPort, never()).save(any(Author.class));

    }

    @Test
    void shouldSaveAuthorOnce(){
        Long authorId = 25L;
        Author author = new Author(authorId, "Marco Avilés",
                "Cholo. Serrano. Inmigrante. Nació en la ciudad de Abancay, creció en San Juan de Lurigancilustre barrio de inmigrantes;");

        when(repositoryPort.save(any(Author.class))).thenReturn(author);

        authorService.create(new CreateAuthorCommand("Marco Avilés",
                "Cholo. Serrano. Inmigrante. Nació en la ciudad de Abancay, creció en San Juan de Lurigancilustre barrio de inmigrantes;"));

        verify(repositoryPort, times(1)).save(any(Author.class));

    }




}
