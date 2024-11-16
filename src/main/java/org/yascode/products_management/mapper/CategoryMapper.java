package org.yascode.products_management.mapper;

import org.yascode.products_management.dto.CategoryDto;
import org.yascode.products_management.entity.Category;

public interface CategoryMapper {
    CategoryDto toDto(Category category);

    Category toEntity(CategoryDto categoryDto);
}
