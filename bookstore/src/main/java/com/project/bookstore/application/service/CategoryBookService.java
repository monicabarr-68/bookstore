package com.project.bookstore.application.service;

import com.project.bookstore.application.port.in.CategoryBookInputPort;
import com.project.bookstore.application.port.out.CategoryBookRepositoryPort;
import com.project.bookstore.domain.model.CategoryBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBookService implements CategoryBookInputPort {

    private final CategoryBookRepositoryPort categoryRepositoryPort;

    public CategoryBookService (CategoryBookRepositoryPort categoryRepositoryPort){
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public CategoryBook createCategoryBook(String name) {
        CategoryBook category = new CategoryBook(name);
        return categoryRepositoryPort.save(category);
    }

    @Override
    public List<CategoryBook> findAllCategories() {
        return categoryRepositoryPort.findAllCategories();
    }
}
