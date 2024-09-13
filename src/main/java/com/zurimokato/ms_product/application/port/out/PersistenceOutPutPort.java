package com.zurimokato.ms_product.application.port.out;

import com.zurimokato.ms_product.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersistenceOutPutPort {

    Product save(Product product);

    Product findById(String id);

    Product findByName(String name);

    Page<Product> findAll(Pageable pageable, Product criteria);
}
