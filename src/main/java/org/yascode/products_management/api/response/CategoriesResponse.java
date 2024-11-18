package org.yascode.products_management.api.response;

import lombok.*;
import org.yascode.products_management.dto.CategoryDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoriesResponse {
    private List<CategoryDto> categories;
    private int totalPages;
    private long totalElements;
}
