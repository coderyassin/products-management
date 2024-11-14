package org.yascode.products_management.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.yascode.products_management.entity.Category;
import org.yascode.products_management.entity.Product;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    private Category category;
    private Product product1, product2;

    @BeforeEach
    public void setupTestData() {
        category = Category.builder()
                .name("Electronics")
                .description("All electronic machines")
                .build();

        categoryRepository.save(category);

        product1 = Product.builder()
                .name("Laptop")
                .price(1500.0)
                .category(category)
                .build();

        product2 = Product.builder()
                .name("Smartphone")
                .price(800.0)
                .category(category)
                .build();

        productRepository.saveAll(List.of(product1, product2));
    }

    @Test
    void testFindByName() {
        List<Product> products = productRepository.findByName("Laptop");
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getName()).isEqualTo("Laptop");
    }

    @Test
    void testFindByNameContains() {
        List<Product> products = productRepository.findByNameContains("phone");
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getName()).isEqualTo("Smartphone");
    }

    @Test
    void testFindByNameContainingAndPriceGreaterThan() {
        List<Product> products = productRepository.findByNameContainingAndPriceGreaterThan("phone", 700.0);
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getPrice()).isGreaterThan(700.0);
    }

    @Test
    void testFindAllByOrderByNameAsc() {
        List<Product> products = productRepository.findAllByOrderByNameAsc();
        assertThat(products.get(0).getName()).isEqualTo("Laptop");
        assertThat(products.get(1).getName()).isEqualTo("Smartphone");
    }

    @Test
    void testFindAllByOrderByNameAscPriceDesc() {
        List<Product> products = productRepository.findByCategoryId(category.getId());
        assertThat(products).hasSize(2);
    }

    @Test
    void testFindByCategoryId() {
        List<Product> products = productRepository.findByCategoryId(category.getId());
        assertThat(products).hasSize(2);
    }

    @Test
    void testFindByCategory() {
        List<Product> products = productRepository.findByCategory(category);
        assertThat(products).hasSize(2);
        assertThat(products).extracting(Product::getName).contains("Laptop", "Smartphone");
    }
}