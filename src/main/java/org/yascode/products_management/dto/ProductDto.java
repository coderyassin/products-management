package org.yascode.products_management.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private String name;
    private Double price;
    private CategoryDto category;
}
