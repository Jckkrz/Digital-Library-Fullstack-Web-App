package com.kurzic.reading_app_backend.DTOs;

import com.kurzic.reading_app_backend.enums.ReadingStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Front end sends to back end
public record BookRequestDTO (
        @NotBlank String title,
        @NotBlank String author,
        String isbn,
        @Min(1) int pageCount,
        @NotNull ReadingStatus status
){
}
