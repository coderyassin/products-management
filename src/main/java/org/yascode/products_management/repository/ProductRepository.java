package org.yascode.products_management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yascode.products_management.entity.Category;
import org.yascode.products_management.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);

    List<Product> findByNameContains(String name);

    List<Product> findByNameContainingAndPriceGreaterThan(String name, Double price);

    List<Product> findAllByOrderByNameAsc();

    List<Product> findAllByOrderByNameAscPriceDesc();

    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByCategory(Category category);

    Page<Product> findByNameContains(String name, Pageable pageable);

}