package com.kurzic.reading_app_backend.services;

import com.kurzic.reading_app_backend.entities.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public BookService() {

        books.add(new Book("1984", "George Orwell", 300));
    }

    public Book addBook(Book newBook){
        books.add(newBook);
        return newBook;
    }

    public List<Book> getBooks(){
        return books;
    }

    public Book getBookById(Long id){
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public void updateBook(Book updatedBook) {

        Book bookToUpdate = getBookById(updatedBook.getId());
        bookToUpdate.setTitle(updatedBook.getTitle());
        bookToUpdate.setAuthor(updatedBook.getAuthor());
        bookToUpdate.setPageCount(updatedBook.getPageCount());

    }

    public void deleteBookByID(Long id){
        books.removeIf(book -> book.getId().equals(id));
    }


}
