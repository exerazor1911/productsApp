package com.programmingtechie.productservice.controller;

import com.programmingtechie.productservice.dto.ProductDTORequest;
import com.programmingtechie.productservice.dto.ProductDTOResponse;
import com.programmingtechie.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createproduct(@RequestBody ProductDTORequest productDTORequest) {
        productService.createProduct(productDTORequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTOResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
