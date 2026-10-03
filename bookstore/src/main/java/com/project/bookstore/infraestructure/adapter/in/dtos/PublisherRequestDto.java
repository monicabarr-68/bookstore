package com.project.bookstore.infraestructure.adapter.in.dtos;

import jakarta.validation.constraints.NotBlank;

public class PublisherRequestDto {
    @NotBlank(message = "El campo no puede estar vacío. Ingrese una editorial.")
    private String name;

    private String website;

    public PublisherRequestDto() {}

    public PublisherRequestDto(String name, String website) {
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
