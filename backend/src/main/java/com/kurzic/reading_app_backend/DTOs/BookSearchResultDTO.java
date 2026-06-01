package com.kurzic.reading_app_backend.DTOs;

public record BookSearchResultDTO(
        String title,
        String author,
        String isbn,
        Integer pageCount
) {}
