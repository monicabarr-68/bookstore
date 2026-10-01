package com.project.bookstore.infraestructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "book_categories")
public class CategoryBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CategoryBookEntity() {}

    public CategoryBookEntity(String name) {this.name = name;}

    public CategoryBookEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
