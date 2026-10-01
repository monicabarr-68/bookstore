package com.project.bookstore.domain.exception;

public class CategoryBookNotFoundException extends RuntimeException{

    public CategoryBookNotFoundException(String message){
        super(message);
    }
}
