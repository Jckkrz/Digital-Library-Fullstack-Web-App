package com.kurzic.reading_app_backend.repositories;


import com.kurzic.reading_app_backend.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface BookRepository extends JpaRepository<Book, Long> {

    }

