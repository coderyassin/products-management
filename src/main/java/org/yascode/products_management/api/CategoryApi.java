package org.yascode.products_management.api;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yascode.products_management.api.response.CategoriesResponse;
import org.yascode.products_management.dto.CategoryDto;

import java.util.List;

import static org.yascode.products_management.util.ApiPaths.Category.*;

@RequestMapping(CATEGORIES)
public interface CategoryApi {
    @GetMapping
    ResponseEntity<List<CategoryDto>> getAllCategories(HttpServletRequest request);

    @GetMapping(ALL)
    ResponseEntity<CategoriesResponse> categories(@RequestParam int page, @RequestParam int size);

    @GetMapping(value = CATEGORY_BY_ID)
    ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id);
    @GetMapping(SEARCH)
    ResponseEntity<CategoriesResponse> searchByName(@RequestParam String search, @RequestParam int page, @RequestParam int size);

    @PostMapping
    ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto);

    @PutMapping(value = CATEGORY_BY_ID)
    ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto);

    @DeleteMapping(value = CATEGORY_BY_ID)
    ResponseEntity<?> deleteCategory(@PathVariable Long id);
}
