package org.yascode.products_management.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.yascode.products_management.entity.Product;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProductListener {
    @PrePersist
    public void prePersist(Product entity) {
        if(Objects.isNull(entity.getCreatedAt())) {
            entity.setCreatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Product entity) {
        if(Objects.isNull(entity.getUpdatedAt())) {
            entity.setUpdatedAt(LocalDateTime.now());
        }
    }
}
