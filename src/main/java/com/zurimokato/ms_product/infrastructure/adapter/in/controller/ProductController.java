package com.zurimokato.ms_product.infrastructure.adapter.in.controller;

import com.zurimokato.ms_product.application.port.in.FindProductUseCase;
import com.zurimokato.ms_product.application.port.in.SaveProductUseCase;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.mapper.ProductApiRestMapper;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.port.ProductPort;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.request.ProductRequest;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.GenericResponse;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.ProductResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/products")
@Tag(name = "Product API")
public class ProductController implements ProductPort {
    private final FindProductUseCase findProductUseCase;
    private final SaveProductUseCase saveProductUseCase;
    private final ProductApiRestMapper productAPIMapper;

    @Override
    @Cacheable(cacheNames = "product")
    public ResponseEntity<GenericResponse> getProducts(Pageable pageable) {
        Page<ProductResponse> page = findProductUseCase.findAllProducts(null, pageable).map(productAPIMapper::toResponse);
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(page.getContent());
        genericResponse.setPageResponse(productAPIMapper.toPageResponse(page));
        return ResponseEntity.ok(genericResponse);
    }


    @Override
    @Cacheable(value = "product", key = "#id")
    public ResponseEntity<GenericResponse> getProduct(String id) {
        ProductResponse response = productAPIMapper.toResponse(findProductUseCase.findProduct(id));
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(response);
        return ResponseEntity.ok(genericResponse);
    }

    public ResponseEntity<GenericResponse> createProduct(ProductRequest productRequest) {
        ProductResponse response = productAPIMapper.toResponse(saveProductUseCase.createProduct(
                productAPIMapper.toModel(productRequest)
        ));
        log.info("product created response: {}", response);
        GenericResponse genericResponse = GenericResponse.success();
        return ResponseEntity.ok(genericResponse);
    }

    @Override
    public ResponseEntity<GenericResponse> updateProduct(ProductRequest productRequest) {
        ProductResponse response = productAPIMapper.toResponse(saveProductUseCase.updateProduct(
                productAPIMapper.toModel(productRequest)
        ));
        log.info("product updated response: {}", response);
        GenericResponse genericResponse = GenericResponse.success();
        return ResponseEntity.ok(genericResponse);
    }
}
