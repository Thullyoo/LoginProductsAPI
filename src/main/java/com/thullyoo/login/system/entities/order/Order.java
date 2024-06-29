package com.thullyoo.login.system.entities.order;

import com.thullyoo.login.system.entities.product.Product;
import com.thullyoo.login.system.entities.user.User;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "TB_ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToMany
    @JoinTable(
            name = "TB_ORDER_PRODUCTS",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double total;

}
