package com.zurimokato.ms_product.infrastructure.adapter.in.controller.request;

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
    private String author;
    private String publisher;
    private String isbn;
    private String title;
}
