package com.example.CompositeKey.model;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @EmbeddedId
    private OrderItemId id;

    private Integer quantity;

    // Default constructor
    public OrderItem() {}

    public OrderItem(OrderItemId id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    // Getters and Setters
    public OrderItemId getId() {
        return id;
    }

    public void setId(OrderItemId id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
