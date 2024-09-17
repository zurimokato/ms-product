package com.zurimokato.ms_product.infrastructure.adapter.in.controller;

import com.zurimokato.ms_product.application.port.in.FindProductUseCase;
import com.zurimokato.ms_product.application.port.in.SaveProductUseCase;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.mapper.ProductApiRestMapper;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.port.ProductPort;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.request.ProductRequest;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.GenericResponse;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/products")
public class ProductController implements ProductPort {
    private final FindProductUseCase findProductUseCase;
    private final SaveProductUseCase saveProductUseCase;
    private final ProductApiRestMapper productAPIMapper;

    @Override
    public ResponseEntity<GenericResponse> getProducts(Pageable pageable) {
        Page<ProductResponse> page = findProductUseCase.findAllProducts(null, pageable).map(productAPIMapper::toResponse);
        GenericResponse genericResponse=GenericResponse.success();
        genericResponse.setData(page.getContent());
        genericResponse.setPageResponse(productAPIMapper.toPageResponse(page));
        return ResponseEntity.ok(genericResponse);
    }


    @Override
    public ResponseEntity<GenericResponse> getProduct(String id) {
        ProductResponse response = productAPIMapper.toResponse(findProductUseCase.findProduct(id));
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(response);
        return ResponseEntity.ok(genericResponse);
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createProduct( @RequestBody ProductRequest productRequest) {
        ProductResponse response = productAPIMapper.toResponse(saveProductUseCase.createProduct(
                productAPIMapper.toModel(productRequest)
        ));
        GenericResponse genericResponse = GenericResponse.success();
        return ResponseEntity.ok(genericResponse);
    }

    @Override
    public ResponseEntity<GenericResponse> updateProduct(ProductRequest productRequest) {
        ProductResponse response = productAPIMapper.toResponse(saveProductUseCase.updateProduct(
                productAPIMapper.toModel(productRequest)
        ));
        GenericResponse genericResponse = GenericResponse.success();
        return ResponseEntity.ok(genericResponse);
    }
}
