package com.thullyoo.login.system.entities.user;

import com.thullyoo.login.system.entities.order.Order;
import com.thullyoo.login.system.entities.role.Role;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "TB_USERS")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String name;
    private String password;

    @Column(unique = true)
    private String email;
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;



    public User() {
    }

    public User(UUID userId, String name, String password, String email, Role role, Set<Order> orders) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.orders = orders;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
