package com.zurimokato.ms_product.infrastructure.adapter.out.database.mappers;

import com.zurimokato.ms_product.domain.model.Product;
import com.zurimokato.ms_product.infrastructure.adapter.out.database.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
    Product toModel(ProductEntity source);

    ProductEntity toEntity(Product source);
}
