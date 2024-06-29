package com.thullyoo.login.system.entities.product;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    private Integer price;

    private Integer quantity;

}
