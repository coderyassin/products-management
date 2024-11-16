package org.yascode.products_management.service.impl;

import org.springframework.stereotype.Service;
import org.yascode.products_management.dto.ProductDto;
import org.yascode.products_management.entity.Category;
import org.yascode.products_management.entity.Product;
import org.yascode.products_management.exception.ProductNotFoundException;
import org.yascode.products_management.mapper.ProductMapper;
import org.yascode.products_management.repository.ProductRepository;
import org.yascode.products_management.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            productRepository.save(product);
            return productMapper.toDto(product);
        }

        throw new ProductNotFoundException("Product not found with id: " + id);
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
    public ProductDto getProduct(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
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
    public List<ProductDto> findProductsByCategoryId(Long id) {
        return productRepository.findByCategoryId(id)
                .stream()
                .map(productMapper::toDto)
                .toList();
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
