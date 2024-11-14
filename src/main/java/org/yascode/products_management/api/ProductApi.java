package org.yascode.products_management.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yascode.products_management.api.response.ProductsResponse;
import org.yascode.products_management.entity.Product;

import java.util.List;

import static org.yascode.products_management.util.ApiPaths.Product.*;

@RequestMapping(PRODUCTS)
public interface ProductApi {
    @GetMapping
    ResponseEntity<ProductsResponse> getAllProducts();

    @GetMapping(value = PRODUCT_BY_ID)
    ResponseEntity<Product> getProductById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody Product product);

    @PutMapping(value = PRODUCT_BY_ID)
    ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product);

    @DeleteMapping(value = PRODUCT_BY_ID)
    ResponseEntity<?> deleteProduct(@PathVariable Long id);

    @GetMapping(value = PRODUCTS_BY_CATEGORY)
    ResponseEntity<ProductsResponse> getProductsByCategory(@PathVariable("id") Long id);
}
