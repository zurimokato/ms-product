package com.zurimokato.ms_product.infrastructure.adapter.in.controller.request;

import com.zurimokato.ms_product.domain.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest implements Serializable {

    private String name;
    private String description;
    private Double price;
    private List<String> images;
    private Long stock;
    private ProductStatus status;
}
