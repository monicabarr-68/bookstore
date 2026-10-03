package com.project.bookstore.application.service;

import com.project.bookstore.application.port.in.CreateAuthorCommand;
import com.project.bookstore.application.port.in.CreateAuthorPort;
import com.project.bookstore.application.port.in.DeleteAuthorPort;
import com.project.bookstore.application.port.in.GetAuthorPort;
import com.project.bookstore.application.port.out.AuthorRepositoryPort;
import com.project.bookstore.domain.exception.AuthorNotFoundException;
import com.project.bookstore.domain.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements CreateAuthorPort, GetAuthorPort, DeleteAuthorPort {

    private final AuthorRepositoryPort authorRepositoryPort;

    public AuthorService(AuthorRepositoryPort authorRepositoryPort){
        this.authorRepositoryPort = authorRepositoryPort;
    }


    @Override
    public Author create(CreateAuthorCommand authorCommand) {
        Author author = new Author(authorCommand.getFullName(), authorCommand.getBiography());
        return authorRepositoryPort.save(author);
    }


    @Override
    public List<Author> findAllAuthors() {
        return authorRepositoryPort.findAllAuthors();
    }

    @Override
    public Author findById(Long id) {
        Optional<Author> authorOptional = authorRepositoryPort.findById(id);
        if (authorOptional.isEmpty()) {
            throw new AuthorNotFoundException("Autor con id " + id + " no encontrado") ;
        } return authorOptional.get();
    }

    @Override
    public void delete(Long id) {
        findById(id);
        authorRepositoryPort.deleteAuthor(id);
    }
}
