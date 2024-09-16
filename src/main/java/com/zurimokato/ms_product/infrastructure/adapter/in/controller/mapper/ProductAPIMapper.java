package com.zurimokato.ms_product.infrastructure.adapter.in.controller.mapper;

import com.zurimokato.ms_product.domain.model.Product;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.request.ProductRequest;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductAPIMapper {

    Product toModel(ProductRequest source);
    ProductResponse toResponse(Product source);
}
