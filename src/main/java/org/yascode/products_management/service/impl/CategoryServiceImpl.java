package org.yascode.products_management.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.yascode.products_management.api.response.CategoriesResponse;
import org.yascode.products_management.dto.CategoryDto;
import org.yascode.products_management.entity.Category;
import org.yascode.products_management.mapper.CategoryMapper;
import org.yascode.products_management.repository.CategoryRepository;
import org.yascode.products_management.service.CategoryService;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        categoryRepository.findById(id).ifPresent(category -> {
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            categoryRepository.save(category);
        });
        return categoryDto;
    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto getCategory(Long id) {
        AtomicReference<CategoryDto> categoryAR = new AtomicReference<>();
        categoryRepository.findById(id).ifPresent(category -> {
            categoryAR.set(categoryMapper.toDto(category));
        });
        return categoryAR.get();
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    @Override
    public CategoriesResponse getAllCategories(int page, int size) {
        Page<Category> categoryPage = categoryRepository.findAll(PageRequest.of(page - 1, size));

        List<CategoryDto> categories = categoryPage.getContent()
                .stream()
                .map(categoryMapper::toDto)
                .toList();

        return CategoriesResponse.builder()
                .totalPages(categoryPage.getTotalPages())
                .totalElements(categoryPage.getTotalElements())
                .categories(categories)
                .build();
    }

    @Override
    public CategoriesResponse searchByName(String search, int page, int size) {
        Page<Category> categoryPage = categoryRepository.findByNameContains(search, PageRequest.of(page - 1, size));

        List<CategoryDto> categories = categoryPage.getContent()
                .stream()
                .map(categoryMapper::toDto)
                .toList();

        return CategoriesResponse.builder()
                .totalPages(categoryPage.getTotalPages())
                .totalElements(categoryPage.getTotalElements())
                .categories(categories)
                .build();
    }
}
