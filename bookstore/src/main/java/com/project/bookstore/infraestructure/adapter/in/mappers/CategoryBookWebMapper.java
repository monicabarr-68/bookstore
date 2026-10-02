package com.project.bookstore.infraestructure.adapter.in;

import com.project.bookstore.domain.model.CategoryBook;

import java.util.List;

public class CategoryBookWebMapper {

    public static CategoryBookDto toCategoryBookDto(CategoryBook categoryBook){
        return new CategoryBookDto(categoryBook.getName());
    }

    public static List<CategoryBookDto> toListOfCategoryBookDto(List<CategoryBook> categoryBookList){
        return categoryBookList.stream()
                .map(categoryBook ->toCategoryBookDto(categoryBook) )
                .toList();
    }

}
