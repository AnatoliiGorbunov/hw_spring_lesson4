package ru.geekbrains.hw_spring_lesson4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.hw_spring_lesson4.model.Product;
import ru.geekbrains.hw_spring_lesson4.repository.ProductRepository;
import ru.geekbrains.hw_spring_lesson4.service.ProductService;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/product/all")
    public List<Product> getTest() {
        return productRepository.getAllProduct();
    }

    @GetMapping("/product/change_quantity")
    public void changeQuantity(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeQuantiti(productId, delta);
    }

    @PostMapping("/product/add")
    public void addProductPost(@RequestBody Product product) {
        productRepository.addProduct(product);
    }

    @GetMapping("/product/delete")
    public void deleteProduct(@RequestParam Long productId){
        productRepository.deleteProduct(productId);
    }
}
