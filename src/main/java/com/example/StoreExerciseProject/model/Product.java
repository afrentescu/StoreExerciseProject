package com.example.StoreExerciseProject.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private long price;

    @Column(name = "description")
    private String description;

   @ManyToOne
   @JsonBackReference
   @JoinColumn(name = "category_id", nullable = false)
    private  Category productCategory;


    public Product(int productId, String name, long price, String  description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
