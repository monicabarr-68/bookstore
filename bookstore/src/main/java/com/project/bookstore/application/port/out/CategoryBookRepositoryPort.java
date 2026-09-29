package com.project.bookstore.application.port.out;

import com.project.bookstore.domain.model.CategoryBook;

import java.util.List;

public interface CategoryBookRepositoryPort {
    CategoryBook save(CategoryBook category);
    List<CategoryBook> findAllCategories();
}
