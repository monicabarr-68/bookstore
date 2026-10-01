package com.project.bookstore.application.port.in;

import com.project.bookstore.domain.model.CategoryBook;

public interface CreateCategoryBookPort {
    CategoryBook createCategoryBook(String name);
}
