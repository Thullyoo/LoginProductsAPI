package com.thullyoo.login.system.repositories;

import com.thullyoo.login.system.entities.order.Order;
import com.thullyoo.login.system.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<List<Order>> findByUser(User user);
}
