package com.project.bookstore.infraestructure.exception;

import com.project.bookstore.domain.exception.AuthorNotFoundException;
import com.project.bookstore.domain.exception.CategoryBookNotFoundException;
import com.project.bookstore.domain.exception.PublisherNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExcetionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAuthorNotFound(AuthorNotFoundException exception){
        ErrorResponse error = new ErrorResponse(404, exception.getMessage(), LocalDateTime.now(), null);
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryBookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCategoryNotFound(CategoryBookNotFoundException exception){
        ErrorResponse error = new ErrorResponse(404, exception.getMessage(), LocalDateTime.now(), null);
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PublisherNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePublisherNotFound(PublisherNotFoundException exception){
        ErrorResponse error = new ErrorResponse(404, exception.getMessage(), LocalDateTime.now(), null);
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }



}
