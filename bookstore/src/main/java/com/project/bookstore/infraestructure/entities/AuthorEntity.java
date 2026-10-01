package com.project.bookstore.infraestructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String biography;

    public AuthorEntity(String fullName, String biography) {
        this.fullName = fullName;
        this.biography = biography;
    }

    public AuthorEntity(Long id, String fullName, String biography) {
        this.id = id;
        this.fullName = fullName;
        this.biography = biography;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
