package com.kurzic.reading_app_backend.services;

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

    public Book addBook(Book newBook){
        return repo.save(newBook);
    }

    public List<Book> getBooks(){
        return repo.findAll();
    }

    public Book getBookById(Long id){
        return repo.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book existing = repo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setTitle(updatedBook.getTitle());
        existing.setAuthor(updatedBook.getAuthor());
        existing.setPageCount(updatedBook.getPageCount());
        existing.setIsbn(updatedBook.getIsbn());

        return repo.save(existing);
    }


    public void deleteBookByID(Long id){
        repo.deleteById(id);
    }


}
