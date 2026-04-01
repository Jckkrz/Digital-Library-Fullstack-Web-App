package com.kurzic.reading_app_backend.controllers;

import com.kurzic.reading_app_backend.DTOs.BookRequestDTO;
import com.kurzic.reading_app_backend.DTOs.BookResponseDTO;
import com.kurzic.reading_app_backend.services.BookService;
import jakarta.validation.Valid;
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
    public BookResponseDTO addBook(@Valid @RequestBody BookRequestDTO newBook) {
        return bookService.addBook(newBook);
    }

    //Read
    @GetMapping
    public List<BookResponseDTO> getAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookResponseDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    //Update
    @PutMapping("/{id}")
    public BookResponseDTO updateBook(@PathVariable Long id, @Valid @RequestBody BookRequestDTO updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }

    //Delete
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookByID(id);
    }
}