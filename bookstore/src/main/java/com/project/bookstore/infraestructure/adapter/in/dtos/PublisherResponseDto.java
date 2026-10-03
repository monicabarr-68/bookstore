package com.project.bookstore.infraestructure.adapter.in.dtos;

public class PublisherResponseDto {

    private String name;
    private String website;

    public PublisherResponseDto() {}

    public PublisherResponseDto(String name, String website) {
        this.name = name;
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
