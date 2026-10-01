package com.project.bookstore.application.port.in;

public class CreateAuthorCommand {
    private String fullName;
    private String biography;

    public CreateAuthorCommand(String fullName, String biography) {
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
