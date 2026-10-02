package com.project.bookstore.infraestructure.adapter.out.adapater;

import com.project.bookstore.application.port.out.AuthorRepositoryPort;
import com.project.bookstore.domain.model.Author;
import com.project.bookstore.infraestructure.adapter.out.repository.AuthorJpaRepository;
import com.project.bookstore.infraestructure.adapter.out.mappers.AuthorPersistanceMapper;
import com.project.bookstore.infraestructure.entities.AuthorEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorPersistanceAdapter implements AuthorRepositoryPort {

    private final AuthorJpaRepository authorJpaRepository;

    public AuthorPersistanceAdapter (AuthorJpaRepository authorJpaRepository){
        this.authorJpaRepository = authorJpaRepository;
    }

    @Override
    public Author save(Author author) {
        AuthorEntity entitySaved = authorJpaRepository.save(AuthorPersistanceMapper.toAuthorEntity(author));
        return AuthorPersistanceMapper.toAuthor(entitySaved);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorJpaRepository.findAll()
                                  .stream()
                                  .map(authorEntity -> AuthorPersistanceMapper.toAuthor(authorEntity))
                                  .toList();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorJpaRepository.findById(id)
                    .map(authorEntity -> AuthorPersistanceMapper.toAuthor(authorEntity));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorJpaRepository.deleteById(id);
    }
}
