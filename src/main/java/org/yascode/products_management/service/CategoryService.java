package org.yascode.products_management.service;

import org.yascode.products_management.api.response.CategoriesResponse;
import org.yascode.products_management.dto.CategoryDto;
import org.yascode.products_management.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto saveCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(Long id, CategoryDto categoryDto);

    void deleteCategory(Category category);

    void deleteCategoryById(Long id);

    CategoryDto getCategory(Long id);

    List<CategoryDto> getAllCategories();

    CategoriesResponse getAllCategories(int page, int size);
}
