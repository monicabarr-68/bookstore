package com.project.bookstore.domain.model;

public class CategoryBook {
    private Long id;
    private String name;

    public CategoryBook() {}

    public CategoryBook(String name) {this.name = name;}

    public CategoryBook(Long id, String name) {
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
