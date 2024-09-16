package com.zurimokato.ms_product.infrastructure.adapter.in.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TShirtRequest extends ProductRequest {
    private String size;
    private String color;
}
