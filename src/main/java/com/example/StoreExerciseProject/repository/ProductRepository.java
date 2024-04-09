package com.example.StoreExerciseProject.repository;

import com.example.StoreExerciseProject.model.Category;
import com.example.StoreExerciseProject.model.Product;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.slf4j.Logger;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    List<Product> findByProductCategory(Category categoryId);

}
