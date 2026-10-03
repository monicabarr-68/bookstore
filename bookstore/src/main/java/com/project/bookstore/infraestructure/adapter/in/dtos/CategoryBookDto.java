package com.project.bookstore.infraestructure.adapter.in.dtos;

import jakarta.validation.constraints.NotBlank;

public class CategoryBookDto {
    @NotBlank(message = "El campo no puede estar vacío. Ingrese una categoría")
    private String name;

    public CategoryBookDto(){}

    public CategoryBookDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
