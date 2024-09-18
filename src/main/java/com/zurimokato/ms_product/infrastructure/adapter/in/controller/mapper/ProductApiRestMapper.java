package com.zurimokato.ms_product.infrastructure.adapter.in.controller.mapper;

import com.zurimokato.ms_product.domain.model.Book;
import com.zurimokato.ms_product.domain.model.Product;
import com.zurimokato.ms_product.domain.model.TShirt;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.request.BookRequest;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.request.ProductRequest;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.request.TShirtRequest;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.BookResponse;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.PageResponse;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.ProductResponse;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.TShirtResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public abstract class ProductApiRestMapper {

    public Product toModel(ProductRequest dto) {
        if (dto instanceof TShirtRequest) {
            return toModel((TShirtRequest) dto);
        }
        if (dto instanceof BookRequest) {
            return toModel((BookRequest) dto);
        }
        throw new IllegalArgumentException("Tipo de producto desconocido: " + dto.getType());
    }

    public ProductResponse toResponse(Product product) {
        if (product instanceof TShirt) {
            return toResponse((TShirt) product);
        }
        if (product instanceof Book) {
            return toResponse((Book) product);
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
    @Mapping(target = "type", constant = "tshirt")
    public abstract TShirt toModel(TShirtRequest dto);

    public abstract TShirtResponse toResponse(TShirt camisa);
    public abstract PageResponse toPageResponse(Page<ProductResponse> page);

    @Mapping(target = "type", constant = "book")
    public abstract Book toModel(BookRequest dto);
    public abstract BookResponse toResponse(Book camisa);
}
