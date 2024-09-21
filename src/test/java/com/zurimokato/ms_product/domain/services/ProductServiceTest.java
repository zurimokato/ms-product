package com.zurimokato.ms_product.domain.services;

import com.zurimokato.ms_product.application.port.out.ProductOutputPort;
import com.zurimokato.ms_product.domain.model.Product;
import org.bson.assertions.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductOutputPort productOutputPort;
    @InjectMocks
    private ProductService productService;

    @Test
    void findProduct() {
       Mockito.when(productOutputPort.findById(Mockito.anyString()))
               .thenReturn(Product.builder().build());
       var product = productService.findProduct("123456789");
       Assertions.assertNotNull(product);
    }

    @Test
    void findAllProducts() {
        Page<Product>products=new PageImpl<>(List.of(Product.builder().build()));
        Mockito.when(productOutputPort.findAll(Mockito.any(), Mockito.any()))
                .thenReturn(products);
        var result=productService.findAllProducts(Product.builder().build(), Pageable.unpaged());
        Mockito.verify(productOutputPort, Mockito.times(1)).findAll(Mockito.any(), Mockito.any());
        Assertions.assertNotNull(result);
    }

    @Test
    void findByName() {
        Page<Product>products=new PageImpl<>(List.of(Product.builder().build()));
        Mockito.when(productOutputPort.findByName(Mockito.anyString(), Mockito.any()))
                .thenReturn(products);
        var product = productService.findByName("agua", Pageable.unpaged());
        Assertions.assertNotNull(product);
    }

    @Test
    void createProduct() {
        Mockito.when(productOutputPort.save(Mockito.any(Product.class))).thenReturn(Product.builder().build());
        var result = productService.createProduct(Product.builder().build());
        Assertions.assertNotNull(result);
    }

    @Test
    void updateProduct() {
        Mockito.when(productOutputPort.findById(Mockito.anyString()))
                .thenReturn(Product.builder().build());
        Mockito.when(productOutputPort.save(Mockito.any(Product.class))).thenReturn(Product.builder().build());
        var result = productService.updateProduct(Product.builder().id("12345678").build());
        Assertions.assertNotNull(result);

    }
}