package org.yascode.products_management.api.response;

import lombok.*;
import org.yascode.products_management.dto.ProductDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductsResponse {
    private List<ProductDto> products;
    private int totalPages;
    private long totalElements;

    public ProductsResponse(List<ProductDto> products) {

    }
}
