package com.project.bookstore.application.port.in;

import com.project.bookstore.domain.model.CategoryBook;

import java.util.List;

public interface CategoryBookInputPort {

    CategoryBook createCategoryBook(String name);
    List<CategoryBook> findAllCategories();

}
