package com.project.bookstore.infraestructure.adapter.in.dtos;

import java.util.List;

public record BookResponseDto (
        Long id,
        String title,
        Double price,
        Integer publicationYear,
        String publisherName,
        List<String> authorNames
) {
}
