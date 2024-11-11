package org.yascode.products_management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.yascode.products_management.listener.CategoryListener;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(CategoryListener.class)
@Table(name = "categories")
@Builder
public class Category extends AbstractEntity {
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;
}
