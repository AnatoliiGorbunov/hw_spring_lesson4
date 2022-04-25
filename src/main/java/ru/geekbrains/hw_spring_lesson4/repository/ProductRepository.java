package ru.geekbrains.hw_spring_lesson4.repository;

import ch.qos.logback.core.net.server.Client;
import org.springframework.stereotype.Component;
import ru.geekbrains.hw_spring_lesson4.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1l, "bread", 30, 1),
                new Product(2l, "milk", 60, 1),
                new Product(3l, "butter", 90, 1),
                new Product(4l, "orange", 120, 1),
                new Product(5l, "banana", 80, 1),
                new Product(6l, "bread", 30, 1)
        ));
    }

    public List<Product> getAllProduct() {
        return Collections.unmodifiableList(productList);
    }

    public Product findBiId(Long id) {
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void add(Long id, String name, Integer cost, Integer quantiti) {
        productList.add(new Product(id, name, cost, quantiti));
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void deleteProduct(Long id) {
        productList.removeIf(c -> c.getId().equals(id));
    }

}
