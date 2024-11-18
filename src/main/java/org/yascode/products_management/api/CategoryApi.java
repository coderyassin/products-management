package org.yascode.products_management.api;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yascode.products_management.dto.CategoryDto;

import java.util.List;

import static org.yascode.products_management.util.ApiPaths.Category.CATEGORIES;
import static org.yascode.products_management.util.ApiPaths.Category.CATEGORY_BY_ID;

@RequestMapping(CATEGORIES)
public interface CategoryApi {
    @GetMapping
    ResponseEntity<List<CategoryDto>> getAllCategories(HttpServletRequest request);

    @GetMapping(value = CATEGORY_BY_ID)
    ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto);

    @PutMapping(value = CATEGORY_BY_ID)
    ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto);

    @DeleteMapping(value = CATEGORY_BY_ID)
    ResponseEntity<?> deleteCategory(@PathVariable Long id);
}
