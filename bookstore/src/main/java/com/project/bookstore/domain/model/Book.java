package com.project.bookstore.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private Long id;
    private String title;
    private Double price;
    private Integer stock;
    private String isbn;
    private String synopsis;
    private Integer numberPages;
    private Integer publicationYear;
    private List<Author> authors = new ArrayList<>(); //Se inicializa creando una lista vacía, y luego agregar valores
    private List<CategoryBook> categories = new ArrayList<>();
    private BookPublisher publisher;

    //CONSTRUCTORS
    public Book() {}

    public Book(Long id, String title, Double price, Integer stock, String isbn,
                String synopsis, Integer numberPages, Integer publicationYear,
                List<Author> authors, List<CategoryBook> categories, BookPublisher publisher) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.isbn = isbn;
        this.synopsis = synopsis;
        this.numberPages = numberPages;
        this.publicationYear = publicationYear;
        if (authors != null){this.authors = authors;}
        if (categories != null){this.categories = categories;}
        this.publisher = publisher;
    }

    public Book(String title, Double price, Integer stock, String isbn, Integer numberPages, Integer publicationYear) {
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.isbn = isbn;
        this.numberPages = numberPages;
        this.publicationYear = publicationYear;
    }

    //GETTERS

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Integer getNumberPages() {
        return numberPages;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<CategoryBook> getCategories() {
        return categories;
    }

    public BookPublisher getPublisher() {
        return publisher;
    }


    //SETTERS: se omite
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setPublisher(BookPublisher publisher) {
        this.publisher = publisher;
    }

    //COMPORTAMIENTOS

}
