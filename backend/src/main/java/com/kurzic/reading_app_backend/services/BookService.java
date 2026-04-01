package com.kurzic.reading_app_backend.services;

import com.kurzic.reading_app_backend.DTOs.BookRequestDTO;
import com.kurzic.reading_app_backend.DTOs.BookResponseDTO;
import com.kurzic.reading_app_backend.entities.Book;
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
        Book book = repo.findById(id).orElse(null);
        if (book == null) return null;

        return mapToResponse(book);
    }

    public BookResponseDTO updateBook(Long id, BookRequestDTO updatedBook) {
        Book existing = repo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setTitle(updatedBook.title());
        existing.setAuthor(updatedBook.author());
        existing.setPageCount(updatedBook.pageCount());
        existing.setIsbn(updatedBook.isbn());

        Book savedBook = repo.save(existing);
        return mapToResponse(savedBook);
    }

    public void deleteBookByID(Long id){
        repo.deleteById(id);
    }

    private BookResponseDTO mapToResponse(Book book) {
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPageCount()
        );
    }
}