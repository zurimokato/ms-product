package com.zurimokato.ms_product.domain.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends Product {
    private String author;
    private String publisher;
    private String isbn;
    private String title;

}
