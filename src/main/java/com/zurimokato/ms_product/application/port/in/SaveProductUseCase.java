package com.zurimokato.ms_product.application.port.in;

import com.zurimokato.ms_product.domain.model.Product;

public interface SaveProductUseCase {
    Product createProduct(Product product);

    Product updateProduct(Product product);
}
