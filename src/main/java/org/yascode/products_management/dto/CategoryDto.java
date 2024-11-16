package org.yascode.products_management.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {
    private String name;
    private String description;
    private List<ProductDto> products;
}
