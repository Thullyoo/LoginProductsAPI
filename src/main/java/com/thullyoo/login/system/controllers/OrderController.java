package com.thullyoo.login.system.controllers;

import com.thullyoo.login.system.DTOs.GetOrderRequest;
import com.thullyoo.login.system.DTOs.OrderRequest;
import com.thullyoo.login.system.DTOs.OrderResponse;
import com.thullyoo.login.system.entities.order.Order;
import com.thullyoo.login.system.services.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order/create")
    @PreAuthorize("hasAuthority('SCOPE_COMMON')")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody @Valid OrderRequest orderRequest) throws CredentialNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(orderRequest));
    }

    @GetMapping("/order/view/all")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
    }

    @GetMapping("/order/view")
    @PreAuthorize("hasAuthority('SCOPE_COMMON')")
    public ResponseEntity<List<Order>> getOrders(@RequestBody @Valid GetOrderRequest getOrderRequest) throws CredentialNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrders(getOrderRequest.email()));
    }
}
