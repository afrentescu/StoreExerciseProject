package com.example.StoreExerciseProject.controller;

import com.example.StoreExerciseProject.model.Product;
import com.example.StoreExerciseProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> saveBook(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return ResponseEntity.ok(newProduct);
    }
}
