package com.zurimokato.ms_product.infrastructure.adapter.in.controller.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.zurimokato.ms_product.domain.enums.ProductStatus;
import io.swagger.v3.oas.annotations.media.Schema;
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
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TShirtRequest.class, name = "tshirt"),
        @JsonSubTypes.Type(value = BookRequest.class, name = "book")
})
public class ProductRequest implements Serializable {

    @Schema(name = "name", description = "Product's name", example="Cien años de soledad")
    private String name;
    @Schema(name = "description", description = "Product's description", example="libro de 100 años de soledad escrito por" +
            "Gabriel Garcia Marque, publicación con a que ganó el premio Nobel de literatura.")
    private String description;
    @Schema(name = "price", description = "Product's price", example="80000.00")
    private Double price;
    @Schema(name = "images", description = "Product's images", example="[\"http://images/image1.jpg\"]")
    private List<String> images;
    @Schema(name = "stock", description = "Product's stock", example="15")
    private Long stock;
    @Schema(name = "status", description = "Product's status", example="ACTIVE")
    private ProductStatus status;
    @Schema(name = "type", description = "Product's type", example="book")
    private String type;
}
