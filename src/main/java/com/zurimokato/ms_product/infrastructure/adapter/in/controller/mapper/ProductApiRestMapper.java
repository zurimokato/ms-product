package com.zurimokato.ms_product.infrastructure.adapter.in.controller.mapper;

import com.zurimokato.ms_product.domain.model.Product;
import com.zurimokato.ms_product.domain.model.TShirt;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.request.ProductRequest;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.request.TShirtRequest;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.PageResponse;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.ProductResponse;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.TShirtResponse;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public abstract class ProductApiRestMapper {

    public Product toModel(ProductRequest dto) {
        if ("tshirt".equals(dto.getType())) {
            return toModel((TShirtRequest) dto);
        }
        throw new IllegalArgumentException("Tipo de producto desconocido: " + dto.getType());
    }

    public ProductResponse toResponse(Product product) {
        if (product instanceof TShirt) {
            return toResponse((TShirt) product);
        }
        if (product != null) {
            return ProductResponse.builder()
                    .id(product.getId())
                    .price(product.getPrice())
                    .name(product.getName())
                    .stock(product.getStock())
                    .description(product.getDescription())
                    .images(product.getImages())
                    .status(product.getStatus())
                    .type(product.getType())
                    .build();
        }
        throw new IllegalArgumentException("Tipo de producto desconocido: " + product.getClass().getSimpleName());
    }

    // Métodos abstractos específicos
    public abstract TShirt toModel(TShirtRequest dto);

    public abstract TShirtResponse toResponse(TShirt camisa);
    public abstract PageResponse toPageResponse(Page<ProductResponse> page);
}
