package com.project.bookstore.infraestructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "publisher")
public class BookPublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String website;

    public BookPublisherEntity() {}

    public BookPublisherEntity(Long id, String website, String name) {
        this.id = id;
        this.website = website;
        this.name = name;
    }

    public BookPublisherEntity(String name, String website) {
        this.name = name;
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
