package com.project.bookstore.domain.exception;

public class PublisherNotFoundException extends RuntimeException {
  public PublisherNotFoundException(String message) {
    super(message);
  }
}
