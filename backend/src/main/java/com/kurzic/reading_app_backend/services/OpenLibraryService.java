package com.kurzic.reading_app_backend.services;

import com.kurzic.reading_app_backend.DTOs.BookSearchResultDTO;
import com.kurzic.reading_app_backend.DTOs.OpenLibraryResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OpenLibraryService {

    private final RestTemplate restTemplate;
    private static final String BASE_URL =
            "https://openlibrary.org/search.json?fields=title,author_name,isbn,number_of_pages_median&title=";

    public OpenLibraryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<BookSearchResultDTO> searchBooks(String query) {
        String url = BASE_URL + query.replace(" ", "+");

        OpenLibraryResponse response = restTemplate.getForObject(
                url,
                OpenLibraryResponse.class
        );

        if (response == null || response.docs() == null) {
            return List.of();
        }

        return response.docs()
                .stream()
                .limit(10)
                .map(doc -> new BookSearchResultDTO(
                        doc.title(),
                        doc.author_name() != null ? doc.author_name().get(0) : "Unknown",
                        doc.isbn() != null ? doc.isbn().get(0) : null,
                        doc.number_of_pages_median() != null ? doc.number_of_pages_median() : 0
                ))
                .toList();
    }
}
