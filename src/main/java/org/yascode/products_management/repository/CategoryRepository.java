package org.yascode.products_management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yascode.products_management.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findByNameContains(String search, PageRequest of);
}