package com.kurzic.reading_app_backend.EntityTests;

import com.kurzic.reading_app_backend.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTests {

    Book book = new Book();

    @BeforeEach
    void setUp() {
        book =  new Book();
    }

    @Test
    void getBookTitle() {
        assertNull(book.getTitle());
    }

    @Test
    void setBookTitle() {
        book.setTitle("Title");
        assertEquals("Title", book.getTitle());
    }

    @Test
    void getAuthor() {
        assertNull(book.getAuthor());
    }

    @Test
    void setAuthor() {
        book.setAuthor("Author");
        assertEquals("Author", book.getAuthor());
    }

    @Test
    void getIsbn() {
        assertNull(book.getIsbn());
    }

    @Test
    void setIsbn() {
        book.setIsbn("ISBN");
        assertEquals("ISBN", book.getIsbn());
    }


}
