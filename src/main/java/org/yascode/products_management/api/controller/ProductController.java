package org.yascode.products_management.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.yascode.products_management.api.ProductApi;
import org.yascode.products_management.api.response.ProductsResponse;
import org.yascode.products_management.entity.Product;
import org.yascode.products_management.service.ProductService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController implements ProductApi {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<ProductsResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return Optional.of(products)
                .map(ProductsResponse::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(ProductsResponse.builder().products(Collections.emptyList()).build()));
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @Override
    public ResponseEntity<Product> createProduct(Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @Override
    public ResponseEntity<Product> updateProduct(Long id, Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<ProductsResponse> getProductsByCategory(Long id) {
        List<Product> products = productService.findProductsByCategoryId(id);
        return Optional.of(products)
                .map(ProductsResponse::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(ProductsResponse.builder().products(Collections.emptyList()).build()));
    }
}
