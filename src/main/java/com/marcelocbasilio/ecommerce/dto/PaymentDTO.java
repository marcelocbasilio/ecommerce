package com.marcelocbasilio.ecommerce.dto;

import com.marcelocbasilio.ecommerce.entities.Payment;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link com.marcelocbasilio.ecommerce.entities.Payment}
 */
public class PaymentDTO implements Serializable {

    private final Long id;
    private final Instant moment;

    public PaymentDTO(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }

    public PaymentDTO(Payment payment) {
        id = payment.getId();
        moment = payment.getMoment();
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDTO entity = (PaymentDTO) o;
        return Objects.equals(this.id, entity.id) &&
               Objects.equals(this.moment, entity.moment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "id = " + id + ", " +
               "moment = " + moment + ")";
    }
}