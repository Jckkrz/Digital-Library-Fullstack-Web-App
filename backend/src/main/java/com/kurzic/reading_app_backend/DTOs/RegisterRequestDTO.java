package com.kurzic.reading_app_backend.DTOs;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDTO(
        @NotBlank String email,
        @NotBlank String password
) {}
