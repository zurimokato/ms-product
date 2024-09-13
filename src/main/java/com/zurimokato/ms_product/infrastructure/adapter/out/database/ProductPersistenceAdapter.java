package com.zurimokato.ms_product.infrastructure.adapter.out.database;

import com.zurimokato.ms_product.application.port.out.PersistenceOutPutPort;
import com.zurimokato.ms_product.domain.model.Product;
import com.zurimokato.ms_product.infrastructure.adapter.out.database.mappers.ProductEntityMapper;
import com.zurimokato.ms_product.infrastructure.adapter.out.database.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements PersistenceOutPutPort {
    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public Product save(Product product) {
        return productEntityMapper.toModel(productRepository.save(productEntityMapper.toEntity(product)));
    }

    @Override
    public Product findById(String id) {
        return productEntityMapper.toModel(
                productRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException("Product not found")
                        )
        );

    }

    @Override
    public Product findByName(String name) {
        return productEntityMapper.toModel(
                productRepository.findByName(name)
                        .orElseThrow(
                                () -> new RuntimeException("Product not found")
                        )
        );
    }

    @Override
    public Page<Product> findAll(Pageable pageable, Product criteria) {
        return null;
    }
}
