package com.zurimokato.ms_product.infrastructure.adapter.in.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(name = "size", description ="T-shirt's size", example = "S")
    private String size;
    @Schema(name = "color", description ="T-shirt's color", example = "rojiblanco")
    private String color;

}
