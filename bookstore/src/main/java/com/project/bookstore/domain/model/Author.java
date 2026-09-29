package com.project.bookstore.domain.model;

public class Author {
    private Long id;
    private String fullName;
    private String biography;

    public Author() {}

    public Author(Long id, String fullName, String biography) {
        this.id = id;
        this.fullName = fullName;
        this.biography = biography;
    }

    public Author(String fullName, String biography) {
        this.fullName = fullName;
        this.biography = biography;
    }

    //GETTERS
    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBiography() {
        return biography;
    }

    //SETTERS
    public void setBiography(String biography) {
        this.biography = biography;
    }
}
