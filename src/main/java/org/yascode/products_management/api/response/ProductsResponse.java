package org.yascode.products_management.api.response;

import lombok.*;
import org.yascode.products_management.entity.Product;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductsResponse {
    private List<Product> products;
}
