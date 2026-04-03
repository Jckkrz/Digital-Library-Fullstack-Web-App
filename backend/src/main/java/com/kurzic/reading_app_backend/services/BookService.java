package com.kurzic.reading_app_backend.services;

import com.kurzic.reading_app_backend.DTOs.BookRequestDTO;
import com.kurzic.reading_app_backend.DTOs.BookResponseDTO;
import com.kurzic.reading_app_backend.entities.Book;
import com.kurzic.reading_app_backend.exceptions.BookNotFoundException;
import com.kurzic.reading_app_backend.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public BookResponseDTO addBook(BookRequestDTO newBook) {
        Book book = new Book();
        book.setTitle(newBook.title());
        book.setAuthor(newBook.author());
        book.setIsbn(newBook.isbn());
        book.setPageCount(newBook.pageCount());
        book.setStatus(newBook.status());

        Book savedBook = repo.save(book);
        return mapToResponse(savedBook);
    }

    public List<BookResponseDTO> getBooks() {
        return repo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public BookResponseDTO getBookById(Long id) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return mapToResponse(book);
    }

    public BookResponseDTO updateBook(Long id, BookRequestDTO updatedBook) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new  BookNotFoundException(id));

        book.setTitle(updatedBook.title());
        book.setAuthor(updatedBook.author());
        book.setPageCount(updatedBook.pageCount());
        book.setIsbn(updatedBook.isbn());
        book.setStatus(updatedBook.status());

        Book savedBook = repo.save(book);
        return mapToResponse(savedBook);
    }

    public void deleteBookByID(Long id) {
        if (!repo.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        repo.deleteById(id);
    }

    private BookResponseDTO mapToResponse(Book book) {
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPageCount(),
                book.getStatus()
        );
    }
}