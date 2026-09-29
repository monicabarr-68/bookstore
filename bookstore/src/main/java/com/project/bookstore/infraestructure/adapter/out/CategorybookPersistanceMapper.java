package com.project.bookstore.infraestructure.adapter.out;

import com.project.bookstore.domain.model.CategoryBook;
import com.project.bookstore.infraestructure.entities.CategoryBookEntity;

public class CategorybookPersistanceMapper {

    public static CategoryBookEntity toCategoryBookEntity(CategoryBook category){
        return new CategoryBookEntity(category.getId(), category.getName());
    }

    public static CategoryBook toCategoryBook(CategoryBookEntity entity){
        return new CategoryBook(entity.getId(), entity.getName());
    }
}
