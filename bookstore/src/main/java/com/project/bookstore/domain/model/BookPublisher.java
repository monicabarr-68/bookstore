package com.project.bookstore.domain.model;

public class BookPublisher {
    private Long id;
    private String name;
    private String website;

    public BookPublisher() {}

    public BookPublisher(Long id, String name, String website){
        this.id = id;
        this.name = name;
        this.website = website;
    }

    public BookPublisher(String name, String website) {
        this.name = name;
        this.website = website;
    }

    //GETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    //SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
