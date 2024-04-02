package com.example.StoreExerciseProject.service;

import com.example.StoreExerciseProject.model.Product;
import com.example.StoreExerciseProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){
        Product newProduct = productRepository.save(product);
        return  newProduct;
    }
}
