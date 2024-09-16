package com.zurimokato.ms_product.domain.services;

import com.zurimokato.ms_product.application.port.in.FindProductUseCase;
import com.zurimokato.ms_product.application.port.in.SaveProductUseCase;
import com.zurimokato.ms_product.application.port.out.ProductOutputPort;
import com.zurimokato.ms_product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ProductService implements FindProductUseCase, SaveProductUseCase {

    private final ProductOutputPort productOutputPort;


    @Override
    public Product findProduct(String id) {
        return productOutputPort.findById(id);
    }

    @Override
    public Page<Product> findAllProducts(Product criteria, Pageable pageable) {
       Page<Product>products= productOutputPort.findAll(pageable,criteria);
       if(products.isEmpty()){
           throw new RuntimeException();
       }

        return products;
    }

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        Page<Product>products= productOutputPort.findByName(name,pageable);
        if(products.isEmpty()){
            throw new RuntimeException();
        }

        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productOutputPort.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product toSave= productOutputPort.findById(product.getId());
        return productOutputPort.save(product);
    }
}
