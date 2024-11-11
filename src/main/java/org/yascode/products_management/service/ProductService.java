package org.yascode.products_management.service;

import org.yascode.products_management.entity.Category;
import org.yascode.products_management.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Product product);
    void deleteProductById(Long id);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    List<Product> findProductsByName(String name);
    List<Product> findProductsByNameContains(String name);
    List<Product> findProductsByNameAndPrice(String name, Double price);
    List<Product> findByProductsCategory(Category category);
    List<Product> findProductsByCategoryId(Long id);
    List<Product> findByOrderByNameAsc();
    List<Product> sortProductsByNamesAndPrices();
}
