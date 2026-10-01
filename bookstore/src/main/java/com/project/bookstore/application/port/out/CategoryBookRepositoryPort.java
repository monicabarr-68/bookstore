package com.project.bookstore.application.port.out;

import com.project.bookstore.domain.model.CategoryBook;

import java.util.List;
import java.util.Optional;

public interface CategoryBookRepositoryPort {
    CategoryBook save(CategoryBook category);
    List<CategoryBook> findAllCategories();
    Optional<CategoryBook> findById(Long id);
    void deleteCategory(Long id);
}
