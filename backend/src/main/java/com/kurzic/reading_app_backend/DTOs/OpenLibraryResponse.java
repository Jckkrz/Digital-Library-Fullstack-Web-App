package com.kurzic.reading_app_backend.DTOs;

import java.util.List;

public record OpenLibraryResponse(
        List<OpenLibrarySearchResult> docs
) {}
