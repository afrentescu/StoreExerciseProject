package com.example.StoreExerciseProject.service;

import com.example.StoreExerciseProject.model.Category;
import com.example.StoreExerciseProject.model.Product;
import com.example.StoreExerciseProject.model.Stock;
import com.example.StoreExerciseProject.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStockForProduct(Product id){
        List<Stock> stocks = stockRepository.findStockByProduct(id);
        if (stocks.isEmpty())
        {
            throw new RuntimeException("there is no stock history available in the specified product!");
        }
        return stocks;
    }


}
