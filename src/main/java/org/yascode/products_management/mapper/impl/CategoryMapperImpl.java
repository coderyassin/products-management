package org.yascode.products_management.mapper.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.yascode.products_management.dto.CategoryDto;
import org.yascode.products_management.entity.Category;
import org.yascode.products_management.mapper.CategoryMapper;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    private final ModelMapper modelMapper;

    public CategoryMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto toDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public Category toEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}
