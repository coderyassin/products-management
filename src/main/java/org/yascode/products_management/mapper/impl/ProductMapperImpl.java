package org.yascode.products_management.mapper.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.yascode.products_management.dto.ProductDto;
import org.yascode.products_management.entity.Product;
import org.yascode.products_management.mapper.ProductMapper;

@Component
public class ProductMapperImpl implements ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto toDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public Product toEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
