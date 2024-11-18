package org.yascode.products_management.api.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.yascode.products_management.api.ProductApi;
import org.yascode.products_management.api.response.ProductsResponse;
import org.yascode.products_management.dto.ProductDto;
import org.yascode.products_management.service.ProductService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController implements ProductApi {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<ProductsResponse> getAllProducts(HttpServletRequest request) {
        List<ProductDto> products = productService.getAllProducts();
        return Optional.of(products)
                .map(ProductsResponse::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(ProductsResponse.builder().products(Collections.emptyList()).build()));
    }

    @Override
    public ResponseEntity<ProductsResponse> products(int page, int size) {
        return ResponseEntity.ok(productService.products(page, size));
    }

    @Override
    public ResponseEntity<ProductDto> getProductById(Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @Override
    public ResponseEntity<?> createProduct(ProductDto productDto) {
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }

    @Override
    public ResponseEntity<?> updateProduct(Long id, ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<ProductsResponse> getProductsByCategory(Long id) {
        List<ProductDto> products = productService.findProductsByCategoryId(id);
        return Optional.of(products)
                .map(ProductsResponse::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(ProductsResponse.builder().products(Collections.emptyList()).build()));
    }
}
