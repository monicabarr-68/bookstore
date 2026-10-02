package com.project.bookstore.infraestructure.adapter.out;

import com.project.bookstore.domain.model.Author;
import com.project.bookstore.infraestructure.entities.AuthorEntity;

public class AuthorPersistanceMapper {

    public static AuthorEntity toAuthorEntity(Author author){
        return new AuthorEntity(author.getId(), author.getFullName(), author.getBiography());
    }

    public static Author toAuthor(AuthorEntity authorEntity){
        return new Author(authorEntity.getId(), authorEntity.getFullName(), authorEntity.getBiography());
    }

}
