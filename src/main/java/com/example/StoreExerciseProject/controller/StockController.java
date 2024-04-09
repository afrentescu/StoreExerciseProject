package com.example.StoreExerciseProject.controller;

import com.example.StoreExerciseProject.model.Category;
import com.example.StoreExerciseProject.model.Product;
import com.example.StoreExerciseProject.model.Stock;
import com.example.StoreExerciseProject.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stockForProduct/{id}")
    public List<Stock> getStockForProduct(@PathVariable Product id){
        return stockService.getStockForProduct(id);
    }
}
