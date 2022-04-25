package ru.geekbrains.hw_spring_lesson4.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Integer cost;
    private Integer quantity;

    public Product(Long id, String name, Integer cost, Integer quantity) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

}
