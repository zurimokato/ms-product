package com.zurimokato.ms_product.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 4464389893632993784L;
    private String id;
    private String name;
    private String description;
    private Double price;
    private List<String> images;
    private Long stock;

}
