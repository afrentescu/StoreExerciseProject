package com.example.StoreExerciseProject.service;

import com.example.StoreExerciseProject.model.Category;
import com.example.StoreExerciseProject.model.Product;
import com.example.StoreExerciseProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(Category category){
        Category newCategory = categoryRepository.save(category);
        return  newCategory;
    }

    public List<Category> getAllCategories(){
        return  categoryRepository.findAll();
    }
}
