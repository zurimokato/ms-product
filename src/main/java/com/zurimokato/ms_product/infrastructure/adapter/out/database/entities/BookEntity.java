package com.zurimokato.ms_product.infrastructure.adapter.out.database.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TypeAlias("book")
public class BookEntity extends ProductEntity {
    private String author;
    private String publisher;
    private String isbn;
    private String title;
}
