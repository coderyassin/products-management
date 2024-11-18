package org.yascode.products_management.api.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.yascode.products_management.api.CategoryApi;
import org.yascode.products_management.api.response.CategoriesResponse;
import org.yascode.products_management.dto.CategoryDto;
import org.yascode.products_management.service.CategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController implements CategoryApi {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategories(HttpServletRequest request) {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @Override
    public ResponseEntity<CategoriesResponse> categories(int page, int size) {
        return ResponseEntity.ok(categoryService.getAllCategories(page, size));
    }

    @Override
    public ResponseEntity<CategoryDto> getCategoryById(Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @Override
    public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.saveCategory(categoryDto));
    }

    @Override
    public ResponseEntity<CategoryDto> updateCategory(Long id, CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryDto));
    }

    @Override
    public ResponseEntity<?> deleteCategory(Long id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().build();
    }
}
