package com.example.StoreExerciseProject.controller;

import com.example.StoreExerciseProject.model.Category;
import com.example.StoreExerciseProject.model.Product;
import com.example.StoreExerciseProject.repository.ProductRepository;
import com.example.StoreExerciseProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/editProduct/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product updatedProduct, @PathVariable Long id) {
        return ResponseEntity.ok(productService.putProduct(updatedProduct, id));
    }

    @GetMapping("/allProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/productsByCategory/{id}")
    public List<Product> getProductsByCategory(@PathVariable Category id){
        return productService.getProductsByCategory(id);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public void deleteProductById(@PathVariable int id){
        productService.deleteProductById(id);
    }
}
