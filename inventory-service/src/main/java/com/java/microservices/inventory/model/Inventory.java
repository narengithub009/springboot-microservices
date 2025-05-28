package com.java.microservices.inventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String skuCode;
    private Integer quantity;
}

// The Inventory class represents the inventory entity with fields for id, skuCode, and quantity.
// It uses JPA annotations to map the class to a database table named "t_inventory".
// Lombok annotations are used to automatically generate getters, setters, and constructors.
// This class is part of a microservices architecture, likely for managing product inventory in an e-commerce application.