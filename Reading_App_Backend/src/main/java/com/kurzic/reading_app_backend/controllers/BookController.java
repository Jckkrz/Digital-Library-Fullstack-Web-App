package com.kurzic.reading_app_backend.controllers;

import com.kurzic.reading_app_backend.services.BookService;
import com.kurzic.reading_app_backend.entities.Book;
import org.springframework.web.bind.annotation.*;
import com.kurzic.reading_app_backend.entities.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book newBook) {
        bookService.addBook(newBook);
        return newBook;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    @PutMapping
    public String updateBook(@RequestBody Book newBook) {
        bookService.updateBook(newBook);
        return newBook.getTitle() + " added to your shelf.";
    }


    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        Book deletedBook = bookService.getBookById(id);
        if (deletedBook == null) {
            return "Book not found";
        }
        bookService.deleteBookByID(id);
        return deletedBook.getTitle() + " deleted from your shelf.";
    }

}
