package com.project.bookstore.infraestructure.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price;
    private Integer stock;
    private String isbn;
    private String synopsis;
    private Integer numberPages;
    private Integer publicationYear;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private BookPublisherEntity publisher;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<AuthorEntity> authors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryBookEntity> categories = new ArrayList<>();

    public BookEntity() {}

    public BookEntity(Long id,
                      String title,
                      Double price,
                      Integer stock,
                      String isbn,
                      String synopsis,
                      Integer numberPages,
                      Integer publicationYear,
                      BookPublisherEntity publisher,
                      List<AuthorEntity> authors,
                      List<CategoryBookEntity> categories) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.isbn = isbn;
        this.synopsis = synopsis;
        this.numberPages = numberPages;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.authors = authors;
        this.categories = categories;
    }

    public List<CategoryBookEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryBookEntity> categories) {
        this.categories = categories;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }

    public BookPublisherEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(BookPublisherEntity publisher) {
        this.publisher = publisher;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Integer getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(Integer numberPages) {
        this.numberPages = numberPages;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
