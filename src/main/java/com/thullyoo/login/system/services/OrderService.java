package com.thullyoo.login.system.services;

import com.thullyoo.login.system.DTOs.OrderRequest;
import com.thullyoo.login.system.DTOs.OrderResponse;
import com.thullyoo.login.system.DTOs.ProductOrderResponse;
import com.thullyoo.login.system.entities.order.Order;
import com.thullyoo.login.system.entities.product.Product;
import com.thullyoo.login.system.entities.user.User;
import com.thullyoo.login.system.exceptions.ProductNotFoundException;
import com.thullyoo.login.system.exceptions.QuantityInsufficientException;
import com.thullyoo.login.system.exceptions.UserNotFoundException;
import com.thullyoo.login.system.repositories.OrderRepository;
import com.thullyoo.login.system.repositories.ProductRepository;
import com.thullyoo.login.system.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) throws CredentialNotFoundException {

        Optional<User> user = userRepository.findByEmail(orderRequest.emailUser());

        if (user.isEmpty()){
            throw new UserNotFoundException("Usuário não encontrado");
        }

        Set<Product> listaDeProdutos = new HashSet<>();
        Double total = 0.0;
        List<ProductOrderResponse> productOrderResponses = new ArrayList<>();

        for (Integer i = 0; i < orderRequest.productsIdQuantity().size(); i++){

            Optional<Product> product = productRepository.findById(orderRequest.productsIdQuantity().get(i).productId());

            if (product.isEmpty()){
                throw new ProductNotFoundException("Produto não encontrado");
            }
            if (product.get().getQuantity() <= 0 || (product.get().getQuantity() - orderRequest.productsIdQuantity().get(i).quantity() < 0)){
                throw new QuantityInsufficientException("Quantidade do produto " + product.get().getName() + " insuficente");
            }
            product.get().setQuantity(product.get().getQuantity() - orderRequest.productsIdQuantity().get(i).quantity());

            productRepository.save(product.get());

            listaDeProdutos.add(product.get());
            total += (product.get().getPrice() * orderRequest.productsIdQuantity().get(i).quantity());

            productOrderResponses.add(new ProductOrderResponse(product.get().getName(), product.get().getPrice() * orderRequest.productsIdQuantity().get(i).quantity(), orderRequest.productsIdQuantity().get(i).quantity()));
        }

        Order order = new Order();
        order.setProducts(listaDeProdutos);
        order.setTotal(total);
        order.setUser(user.get());

        orderRepository.save(order);





        return new OrderResponse(productOrderResponses, total);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public List<Order> getOrders(String email) throws CredentialNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()){
            throw new UserNotFoundException("Usuário não encontrado");
        }

        Optional<List<Order>> orders = orderRepository.findByUser(user.get());
        if (orders.isEmpty()){
            throw new CredentialNotFoundException("Nenhum pedido feito.");
        }
        return orders.get();
    }
}
