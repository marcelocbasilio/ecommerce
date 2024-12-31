package com.marcelocbasilio.ecommerce.repositories;

import com.marcelocbasilio.ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
