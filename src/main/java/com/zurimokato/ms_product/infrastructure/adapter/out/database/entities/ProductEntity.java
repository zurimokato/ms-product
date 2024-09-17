package com.zurimokato.ms_product.infrastructure.adapter.out.database.entities;

import com.zurimokato.ms_product.domain.enums.ProductStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Document("products")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TypeAlias("product")
public class ProductEntity implements Serializable {
    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private Long stock;
    private List<String> images;
    private String type;
    private ProductStatus status;


}
