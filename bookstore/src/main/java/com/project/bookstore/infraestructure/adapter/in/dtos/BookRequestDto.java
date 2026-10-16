package com.project.bookstore.infraestructure.adapter.in.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record BookRequestDto(
        @NotBlank(message = "El campo no puede estar vacío. Ingrese un título.")
        String title,

        @NotNull(message = "El precio es obligatorio")
        @Positive(message = "El precio debe ser mayor a cero")
        Double price,

        @NotNull(message = "El stock es obligatorio")
        @Min(value = 1, message = "El stock no puede ser negativo")
        Integer stock,

        @NotNull(message = "El número de páginas es obligatorio")
        @Positive(message = "El número de páginas debe ser válido")
        Integer numberPages,

        @NotNull(message = "El año de publicación es obligatorio")
        Integer publicationYear,

        @NotNull(message = "El ID de la editorial es obligatorio")
        @Positive(message = "El número de ID debe ser válido")
        Long publisherId,

        @NotNull(message = "Debe enviar al menos un ID de autor")
        @Positive(message = "El número de ID debe ser válido")
        List<Long> authorsId
) {
}
