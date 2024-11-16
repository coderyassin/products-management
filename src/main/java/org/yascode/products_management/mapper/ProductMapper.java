package org.yascode.products_management.mapper;

import org.yascode.products_management.dto.ProductDto;
import org.yascode.products_management.entity.Product;

public interface ProductMapper {
    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
}
