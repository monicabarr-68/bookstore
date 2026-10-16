package com.project.bookstore.application.port.in;

import java.util.List;

public record CreateBookCommand(
        String title,
        Double price,
        Integer stock,
        Integer numberPages,
        Integer publicationYear,
        Long publisherId,
        List<Long> authorsId
        ) {

}
