package com.example.StoreExerciseProject.service;

import com.example.StoreExerciseProject.exceptions.ProductNotFoundException;
import com.example.StoreExerciseProject.model.Category;
import com.example.StoreExerciseProject.model.Product;
import com.example.StoreExerciseProject.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    public Product addProduct(Product product){
        Product newProduct = productRepository.save(product);
        return  newProduct;
    }

    public List<Product> getAllProducts(){
        List<Product> products = new LinkedList<>();
        productRepository.findAll().iterator().forEachRemaining(products::add);
        return products;
    }

    public List<Product> getProductsByCategory(Category categoryId){
        List<Product> products = productRepository.findByProductCategory(categoryId);
        if (products.isEmpty())
        {
            throw new RuntimeException("there are no products available in the specified category!");
        }
        return products;
    }

    public void deleteProductById(int id){
        productRepository.deleteById(Long.valueOf(id));
        logger.info("The product with id: " + id + " was deleted");
    }

    public Product putProduct(@RequestBody Product product, @PathVariable Long id)  {
        Product updatedProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: " + id + " does not exist"));
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setName(product.getName());
        updatedProduct.setDescription(product.getDescription());
        logger.info("Product with id: " + id + " was updated");
        return productRepository.save(product);

    }
}
