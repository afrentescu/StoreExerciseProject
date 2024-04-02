package com.example.StoreExerciseProject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private int stockId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private  Product product;


    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
