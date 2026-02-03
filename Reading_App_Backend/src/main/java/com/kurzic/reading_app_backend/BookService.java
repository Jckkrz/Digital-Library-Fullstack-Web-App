package com.kurzic.reading_app_backend;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(1, "The Hobbit", "J.R.R. Tolkien", 700));
        books.add(new Book(2, "1984", "George Orwell", 300));
    }

    public void addBook(Book newBook){
        books.add(newBook);
    }

    public List<Book> getBooks(){
        return books;
    }

    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == updatedBook.getId()) {
                books.set(i, updatedBook);
            }
        }
    }

    public void deleteBookByID(@PathVariable int id){
        books.removeIf(book -> book.getId() == id);
    }


}
