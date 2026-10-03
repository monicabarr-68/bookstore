package com.project.bookstore.infraestructure.adapter.in.mappers;

import com.project.bookstore.domain.model.CategoryBook;
import com.project.bookstore.infraestructure.adapter.in.dtos.CategoryBookDto;

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
