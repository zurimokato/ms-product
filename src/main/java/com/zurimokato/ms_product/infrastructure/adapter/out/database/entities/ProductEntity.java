package com.zurimokato.ms_product.infrastructure.adapter.out.database.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("products")
@Getter
@Setter
@Builder
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private Long stock;
    private List<String> images;

}
