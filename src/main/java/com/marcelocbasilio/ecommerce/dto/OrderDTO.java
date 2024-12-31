package com.marcelocbasilio.ecommerce.dto;

import com.marcelocbasilio.ecommerce.entities.Order;
import com.marcelocbasilio.ecommerce.entities.OrderItem;
import com.marcelocbasilio.ecommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.marcelocbasilio.ecommerce.entities.Order}
 */
public class OrderDTO implements Serializable {

    private final Long id;
    private final Instant moment;
    private final OrderStatus status;
    private final ClientDTO client;
    private final PaymentDTO payment;

    @NotEmpty(message = "Deve ter pelo menos um item")
    private final List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        this.status = order.getStatus();
        this.client = new ClientDTO(order.getClient());
        this.payment = (order.getPayment() == null) ? null : new PaymentDTO(order.getPayment());
        for (OrderItem item : order.getItems()) {
            OrderItemDTO itemDTO = new OrderItemDTO(item);
            this.items.add(itemDTO);
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public Double getTotal() {
        double sum = 0.0;
        for (OrderItemDTO item : items) {
            sum += item.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO entity = (OrderDTO) o;
        return Objects.equals(this.id, entity.id) &&
               Objects.equals(this.moment, entity.moment) &&
               Objects.equals(this.status, entity.status) &&
               Objects.equals(this.client, entity.client) &&
               Objects.equals(this.payment, entity.payment) &&
               Objects.equals(this.items, entity.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment, status, client, payment, items);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "id = " + id + ", " +
               "moment = " + moment + ", " +
               "status = " + status + ", " +
               "client = " + client + ", " +
               "payment = " + payment + ", " +
               "items = " + items + ")";
    }
}