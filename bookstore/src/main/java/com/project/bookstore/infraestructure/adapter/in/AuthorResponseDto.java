package com.project.bookstore.infraestructure.adapter.in;

public class AuthorResponseDto {
    private String fullName;
    private String biography;

    public AuthorResponseDto() {}

    public AuthorResponseDto(String fullName, String biography) {
        this.fullName = fullName;
        this.biography = biography;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
