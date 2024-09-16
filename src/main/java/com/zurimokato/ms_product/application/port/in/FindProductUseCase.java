package com.zurimokato.ms_product.application.port.in;

import com.zurimokato.ms_product.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindProductUseCase {

    Product findProduct(String id);
    Page<Product>findAllProducts(Product criteria,Pageable pageable);
    Page<Product>findByName(String name,Pageable pageable);

}
