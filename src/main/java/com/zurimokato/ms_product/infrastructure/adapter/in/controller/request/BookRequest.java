package com.zurimokato.ms_product.infrastructure.adapter.in.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BookRequest extends ProductRequest {
    @Schema(name = "author", description = "Book's author", example = "Gabriel Garcia Marquez")
    private String author;
    @Schema(name = "publisher",description = "Book's publisher",example = "Editorial Sudamericana")
    private String publisher;
    @Schema(name = "isbn",description = "Book's isbn",example = "9780060114183")
    private String isbn;
    @Schema(name = "tittle",description = "Book's tittle",example = "100 años de soledad")
    private String title;
}
