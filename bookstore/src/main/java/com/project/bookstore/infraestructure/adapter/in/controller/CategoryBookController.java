package com.project.bookstore.infraestructure.adapter.in.controller;

import com.project.bookstore.application.port.in.CreateCategoryBookPort;
import com.project.bookstore.application.port.in.DeleteCategoryBookPort;
import com.project.bookstore.application.port.in.GetCategoryBookPort;
import com.project.bookstore.infraestructure.adapter.in.dtos.CategoryBookDto;
import com.project.bookstore.infraestructure.adapter.in.mappers.CategoryBookWebMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryBookController {

    private final GetCategoryBookPort getCategoryPort;
    private final CreateCategoryBookPort createCategoryPort;
    private final DeleteCategoryBookPort deleteCategoryPort;

    public CategoryBookController(GetCategoryBookPort getCategoryPort,
                                  CreateCategoryBookPort createCategoryPort,
                                  DeleteCategoryBookPort deleteCategoryPort){
        this.getCategoryPort = getCategoryPort;
        this.createCategoryPort = createCategoryPort;
        this.deleteCategoryPort = deleteCategoryPort;
    }

    @GetMapping
    public List<CategoryBookDto> findAllCategories(){
        return CategoryBookWebMapper.toListOfCategoryBookDto(getCategoryPort.findAllCategories());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryBookDto findById(@PathVariable Long id){
        return CategoryBookWebMapper.toCategoryBookDto(getCategoryPort.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryBookDto create(@Valid @RequestBody CategoryBookDto categoryRequest){
        return CategoryBookWebMapper.toCategoryBookDto(
                createCategoryPort.createCategoryBook(categoryRequest.getName()));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        deleteCategoryPort.deleteCategory(id);
    }



}
