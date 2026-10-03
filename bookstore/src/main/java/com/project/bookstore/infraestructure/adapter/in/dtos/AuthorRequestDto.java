package com.project.bookstore.infraestructure.adapter.in.dtos;

import jakarta.validation.constraints.NotBlank;

public class AuthorRequestDto {

    @NotBlank(message = "El campo no puede estar vacío. Ingrese un author.")
    private String fullName;

    private String biography;

    public AuthorRequestDto() {}

    public AuthorRequestDto(String fullName, String biography) {
        this.fullName = fullName;
        this.biography = biography;
    }

    public String getFullName() {
        return fullName;
    }


    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
