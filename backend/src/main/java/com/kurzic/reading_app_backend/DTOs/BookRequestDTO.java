package com.kurzic.reading_app_backend.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

// Front end sends to back end
public record BookRequestDTO (
        @NotBlank String title,
        @NotBlank String author,
        String isbn,
        @Min(1) int pageCount
){
}
