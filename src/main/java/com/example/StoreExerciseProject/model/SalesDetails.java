package com.example.StoreExerciseProject.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SalesDetails")
public class SalesDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salesDetails_id")
    private int salesDetailsId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private  Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private long price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id", referencedColumnName = "sale_id")
    private Sales sales;
}
