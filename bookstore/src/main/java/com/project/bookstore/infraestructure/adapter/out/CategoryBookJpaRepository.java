package com.project.bookstore.infraestructure.adapter.out;

import com.project.bookstore.infraestructure.entities.CategoryBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryBookJpaRepository extends JpaRepository<CategoryBookEntity, Long> {

}
