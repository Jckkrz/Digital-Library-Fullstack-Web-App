package com.kurzic.reading_app_backend.entities;

import com.kurzic.reading_app_backend.enums.ReadingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Books")
public class Book {

   @Id //This is the primary key for a database
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String isbn;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private Integer pageCount;
    @Column
    @Enumerated(EnumType.STRING)
    private ReadingStatus status;

    public Book(){}

    public Book(String title, String author, Integer pageCount) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {this.isbn = isbn;}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPageCount() {
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public ReadingStatus getStatus() {
        return status;
    }
    public void setStatus(ReadingStatus status) {
        this.status = status;
    }


}
