package com.project.bookstore.infraestructure.adapter.out.repository;

import com.project.bookstore.infraestructure.entities.BookPublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherJpaRepository extends JpaRepository<BookPublisherEntity,Long> {
}
