package com.kurzic.reading_app_backend.DTOs;

import java.util.List;

public record OpenLibrarySearchResult(
        String title,
        List<String> author_name,
        List<String> isbn,
        Integer number_of_pages_median

) {}


