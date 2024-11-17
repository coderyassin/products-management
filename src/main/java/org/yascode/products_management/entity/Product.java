package org.yascode.products_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.yascode.products_management.listener.ProductListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(ProductListener.class)
@Table(name = "products")
@Builder
public class Product extends AbstractEntity {
  private String name;
  private Double price;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "category_id", nullable = false)
  @JsonIgnore
  private Category category;
}