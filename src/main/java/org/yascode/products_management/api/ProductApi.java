package org.yascode.products_management.api;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yascode.products_management.api.response.ProductsResponse;
import org.yascode.products_management.dto.ProductDto;

import static org.yascode.products_management.util.ApiPaths.Product.*;

@RequestMapping(PRODUCTS)
public interface ProductApi {
    @GetMapping
    ResponseEntity<ProductsResponse> getAllProducts(HttpServletRequest request);

    @GetMapping(ALL)
    ResponseEntity<ProductsResponse> products(@RequestParam int page, @RequestParam int size);

    @GetMapping(value = PRODUCT_BY_ID)
    ResponseEntity<ProductDto> getProductById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<?> createProduct(@RequestBody ProductDto productDto);

    @PutMapping(value = PRODUCT_BY_ID)
    ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto);

    @DeleteMapping(value = PRODUCT_BY_ID)
    ResponseEntity<?> deleteProduct(@PathVariable Long id);

    @GetMapping(value = PRODUCTS_BY_CATEGORY)
    ResponseEntity<ProductsResponse> getProductsByCategory(@PathVariable("id") Long id);
}
