package org.yascode.products_management.service;

import org.yascode.products_management.api.response.ProductsResponse;
import org.yascode.products_management.dto.ProductDto;
import org.yascode.products_management.entity.Category;
import org.yascode.products_management.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Product product);

    void deleteProductById(Long id);

    ProductDto getProduct(Long id);

    List<ProductDto> getAllProducts();

    ProductsResponse products(int page, int size);

    ProductsResponse searchByName(String name, int page, int size);

    List<Product> findProductsByName(String name);

    List<Product> findProductsByNameContains(String name);

    List<Product> findProductsByNameAndPrice(String name, Double price);

    List<Product> findByProductsCategory(Category category);

    List<ProductDto> findProductsByCategoryId(Long id);

    List<Product> findByOrderByNameAsc();

    List<Product> sortProductsByNamesAndPrices();
}
