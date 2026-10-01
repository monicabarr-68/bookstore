package com.project.bookstore.application.port.in;

import com.project.bookstore.domain.model.CategoryBook;

import java.util.List;

public interface GetCategoryBookPort {

    List<CategoryBook> findAllCategories();
    CategoryBook findById(Long id);

}
