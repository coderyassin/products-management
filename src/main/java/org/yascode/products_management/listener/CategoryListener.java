package org.yascode.products_management.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.yascode.products_management.entity.Category;

import java.time.LocalDateTime;
import java.util.Objects;

public class CategoryListener {
    @PrePersist
    public void prePersist(Category entity) {
        if(Objects.isNull(entity.getCreatedAt())) {
            entity.setCreatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Category entity) {
        if(Objects.isNull(entity.getUpdatedAt())) {
            entity.setUpdatedAt(LocalDateTime.now());
        }
    }
}
