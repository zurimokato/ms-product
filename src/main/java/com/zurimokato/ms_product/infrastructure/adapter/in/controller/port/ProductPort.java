package com.zurimokato.ms_product.infrastructure.adapter.in.controller.port;

import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.GenericResponse;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.request.ProductRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface ProductPort {

    @GetMapping
    ResponseEntity<GenericResponse> getProducts(Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<GenericResponse> getProduct(@PathVariable String id);


    @PutMapping
    ResponseEntity<GenericResponse> updateProduct(@RequestBody ProductRequest productRequest);

}
