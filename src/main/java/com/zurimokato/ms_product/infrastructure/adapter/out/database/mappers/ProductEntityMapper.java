package com.zurimokato.ms_product.infrastructure.adapter.out.database.mappers;

import com.zurimokato.ms_product.domain.model.Product;
import com.zurimokato.ms_product.domain.model.TShirt;
import com.zurimokato.ms_product.infrastructure.adapter.out.database.entities.ProductEntity;
import com.zurimokato.ms_product.infrastructure.adapter.out.database.entities.TShirtEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ProductEntityMapper {
    public ProductEntity toEntity(Product dto) {
        if ("tshirt".equals(dto.getType())) {
            return toEntity((TShirt) dto);
        }
        throw new IllegalArgumentException("Tipo de producto desconocido: " + dto.getType());
    }

    public Product toModel(ProductEntity product) {
        if (product instanceof TShirtEntity) {
            return toModel((TShirtEntity) product);
        }
        if (product != null) {

            return Product.builder()
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
    public abstract TShirtEntity toEntity(TShirt dto);

    @Mapping(target = "type", constant = "tshirt")
    public abstract TShirt toModel(TShirtEntity camisa);
}
