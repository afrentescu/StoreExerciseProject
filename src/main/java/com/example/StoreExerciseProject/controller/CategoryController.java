package com.example.StoreExerciseProject.controller;

import com.example.StoreExerciseProject.model.Category;
import com.example.StoreExerciseProject.model.Product;
import com.example.StoreExerciseProject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<Category> saveBook(@RequestBody Category category){
        Category newCategory = categoryService.addCategory(category);
        return ResponseEntity.ok(newCategory);
    }

    @GetMapping("/categoriesList")
    public List<Category> getAllcateg(){
       return  categoryService.getAllCategories();
    }
}
