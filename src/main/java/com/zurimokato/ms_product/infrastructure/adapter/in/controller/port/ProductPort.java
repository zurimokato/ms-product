package com.zurimokato.ms_product.infrastructure.adapter.in.controller.port;

import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.GenericResponse;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.request.ProductRequest;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.ProductResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface ProductPort {

    @GetMapping
    HttpEntity<PagedModel<EntityModel<ProductResponse>>> getProducts(Pageable pageable, PagedResourcesAssembler<ProductResponse> assembler);

    @GetMapping("/{id}")
    ResponseEntity<GenericResponse> getProduct(@PathVariable String id);

    @PostMapping
    ResponseEntity<GenericResponse> createProduct(@RequestBody ProductRequest productRequest);

    @PutMapping
    ResponseEntity<GenericResponse> updateProduct(@RequestBody ProductRequest productRequest);

}
