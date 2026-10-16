package com.project.bookstore.infraestructure.adapter.out.repository;

import com.project.bookstore.infraestructure.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
}
