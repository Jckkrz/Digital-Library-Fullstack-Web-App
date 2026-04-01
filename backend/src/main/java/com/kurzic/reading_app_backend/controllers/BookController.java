package com.kurzic.reading_app_backend.controllers;

import jakarta.validation.Valid;
import com.kurzic.reading_app_backend.services.BookService;
import com.kurzic.reading_app_backend.entities.Book;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Create
    @PostMapping
    public Book addBook(@Valid @RequestBody Book newBook) {
        return bookService.addBook(newBook);
    }

    //Read
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    //Update
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @Valid @RequestBody Book newBook) {
        return bookService.updateBook(id, newBook);
    }

    //Delete
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookByID(id);
    }
}

