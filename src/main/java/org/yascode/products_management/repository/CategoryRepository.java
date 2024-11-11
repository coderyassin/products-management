package org.yascode.products_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yascode.products_management.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}