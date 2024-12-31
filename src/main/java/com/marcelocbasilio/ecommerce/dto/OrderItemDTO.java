package com.marcelocbasilio.ecommerce.dto;

import com.marcelocbasilio.ecommerce.entities.OrderItem;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.marcelocbasilio.ecommerce.entities.OrderItem}
 */
public class OrderItemDTO implements Serializable {

    private final Long productId;
    private final String name;
    private final Integer quantity;
    private final Double price;

    public OrderItemDTO(Long productId, String name, Integer quantity, Double price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemDTO(OrderItem orderItem) {
        productId = orderItem.getProduct().getId();
        name = orderItem.getProduct().getName();
        quantity = orderItem.getQuantity();
        price = orderItem.getPrice();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemDTO entity = (OrderItemDTO) o;
        return Objects.equals(this.quantity, entity.quantity) &&
               Objects.equals(this.price, entity.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "quantity = " + quantity + ", " +
               "price = " + price + ")";
    }
}