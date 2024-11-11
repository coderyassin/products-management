package org.yascode.products_management.service.impl;

import org.springframework.stereotype.Service;
import org.yascode.products_management.entity.Category;
import org.yascode.products_management.entity.Product;
import org.yascode.products_management.exception.ProductNotFoundException;
import org.yascode.products_management.repository.ProductRepository;
import org.yascode.products_management.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findProductsByNameContains(String name) {
        return productRepository.findByNameContains(name);
    }

    @Override
    public List<Product> findProductsByNameAndPrice(String name, Double price) {
        return productRepository.findByNameContainingAndPriceGreaterThan(name, price);
    }

    @Override
    public List<Product> findByProductsCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findProductsByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

    @Override
    public List<Product> findByOrderByNameAsc() {
        return productRepository.findAllByOrderByNameAsc();
    }

    @Override
    public List<Product> sortProductsByNamesAndPrices() {
        return productRepository.findAllByOrderByNameAsc();
    }
}
