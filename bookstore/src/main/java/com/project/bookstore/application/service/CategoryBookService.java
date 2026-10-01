package com.project.bookstore.application.service;

import com.project.bookstore.application.port.in.CreateCategoryBookPort;
import com.project.bookstore.application.port.in.DeleteCategoryBookPort;
import com.project.bookstore.application.port.in.GetCategoryBookPort;
import com.project.bookstore.application.port.out.CategoryBookRepositoryPort;
import com.project.bookstore.domain.exception.CategoryBookNotFoundException;
import com.project.bookstore.domain.model.CategoryBook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryBookService implements CreateCategoryBookPort, GetCategoryBookPort, DeleteCategoryBookPort {

    private final CategoryBookRepositoryPort categoryRepositoryPort;

    public CategoryBookService (CategoryBookRepositoryPort categoryRepositoryPort){
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public List<CategoryBook> findAllCategories() {
        return categoryRepositoryPort.findAllCategories();
    }

    @Override
    public CategoryBook findById(Long id) {
       Optional<CategoryBook> categoryOptional= categoryRepositoryPort.findById(id);

       if (categoryOptional.isEmpty()){
           throw new CategoryBookNotFoundException("Categoría con id " + id + " no encontrado");
       }
        return categoryOptional.get();
    }

    @Override
    public CategoryBook createCategoryBook(String name) {
        CategoryBook category = new CategoryBook(name);
        return categoryRepositoryPort.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepositoryPort.deleteCategory(id);
    }
}
