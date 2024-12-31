package com.marcelocbasilio.ecommerce.repositories;

import com.marcelocbasilio.ecommerce.entities.OrderItem;
import com.marcelocbasilio.ecommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}