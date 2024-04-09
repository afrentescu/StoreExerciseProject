package com.example.StoreExerciseProject.repository;

import com.example.StoreExerciseProject.model.Product;
import com.example.StoreExerciseProject.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findStockByProduct(Product id);
}
