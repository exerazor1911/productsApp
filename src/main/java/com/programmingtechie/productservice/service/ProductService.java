package com.programmingtechie.productservice.service;

import com.programmingtechie.productservice.dto.ProductDTORequest;
import com.programmingtechie.productservice.dto.ProductDTOResponse;
import com.programmingtechie.productservice.model.Product;
import com.programmingtechie.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductDTORequest productDTORequest) {
        Product product = Product.builder()
                .name(productDTORequest.getName())
                .description(productDTORequest.getDescription())
                .price(productDTORequest.getPrice())
                .build();

        productRepository.save(product);

        log.info(String.format("Product {} is saved", product.getId()));
    }

    public List<ProductDTOResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductDTOResponse mapToProductResponse(Product product) {
        return ProductDTOResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
