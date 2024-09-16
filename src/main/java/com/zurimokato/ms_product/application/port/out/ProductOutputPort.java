package com.zurimokato.ms_product.application.port.out;

import com.zurimokato.ms_product.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductOutputPort {

    Product save(Product product);

    Product findById(String id);

    Page<Product> findByName(String name,Pageable pageable);

    Page<Product> findAll(Pageable pageable, Product criteria);
}
