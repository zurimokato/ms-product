package com.zurimokato.ms_product.domain.model;

import com.zurimokato.ms_product.domain.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 4464389893632993784L;
    private String id;
    private String name;
    private String description;
    private Double price;
    private List<String> images;
    private Long stock;
    private String type;
    private ProductStatus status;

}
