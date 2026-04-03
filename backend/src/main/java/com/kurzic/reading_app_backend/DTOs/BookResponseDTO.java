package com.kurzic.reading_app_backend.DTOs;

import com.kurzic.reading_app_backend.enums.ReadingStatus;

// Back end sends to front end
public record BookResponseDTO(
        Long id,
        String title,
        String author,
        String isbn,
        int pageCount,
        ReadingStatus status
) {}
