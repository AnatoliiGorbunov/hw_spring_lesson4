package ru.geekbrains.hw_spring_lesson4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.hw_spring_lesson4.model.Product;
import ru.geekbrains.hw_spring_lesson4.repository.ProductRepository;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void changeQuantiti(Long id, Integer quantiti){
        Product product = repository.findBiId(id);
        product.setQuantity(product.getQuantity() + quantiti);
    }

}
