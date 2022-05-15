package com.example.ecom.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String nom;
    private double prix;
    private double quantity;
    @ManyToOne
    private Category category;
}
