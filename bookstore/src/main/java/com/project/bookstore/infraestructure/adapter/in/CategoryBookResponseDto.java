package com.project.bookstore.infraestructure.adapter.in;

public class CategoryBookResponseDto {
    private String name;

    public CategoryBookResponseDto(){}

    public CategoryBookResponseDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
