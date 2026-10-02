package com.project.bookstore.infraestructure.adapter.out;

import com.project.bookstore.infraestructure.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorJpaRepository extends JpaRepository<AuthorEntity, Long> {
}
