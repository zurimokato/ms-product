package com.zurimokato.ms_product.infrastructure.adapter.in.controller.port;

import com.zurimokato.ms_product.infrastructure.adapter.in.controller.response.GenericResponse;
import com.zurimokato.ms_product.infrastructure.adapter.in.controller.request.ProductRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface ProductPort {

    @GetMapping
    @Operation(summary = "Get a page of products", description = "Get a page of products like toys,tshirt, books etc.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "OK"),
            @ApiResponse(responseCode = "400", description = "Product not found")
    })

    ResponseEntity<GenericResponse> getProducts(Pageable pageable);
    @GetMapping("/{id}")
    @Operation(summary = "Get a Product by id", description = "Get a only Product as per id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "OK"),
            @ApiResponse(responseCode = "400", description = "Product not found")
    })
    ResponseEntity<GenericResponse> getProduct(@PathVariable @Parameter(name = "id", description = "Product id",
                                                example = "1") String id);

    @PostMapping
    @Operation(summary = "Create a product", description = "Create a product example Tshirt, Book, Toy")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "OK"),
            @ApiResponse(responseCode = "500", description = "Product not created")
    })
    ResponseEntity<GenericResponse> createProduct( @RequestBody ProductRequest productRequest);


    @PutMapping
    ResponseEntity<GenericResponse> updateProduct(@RequestBody ProductRequest productRequest);

}
