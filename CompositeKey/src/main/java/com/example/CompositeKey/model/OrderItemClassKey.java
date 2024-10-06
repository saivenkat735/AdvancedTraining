package com.example.CompositeKey.model;

import java.io.Serializable;

public class OrderItemClassKey implements Serializable {
    private Long orderId;
    private Long productId;

    // Default constructor
    public OrderItemClassKey() {}

    public OrderItemClassKey(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // equals() and hashCode() methods (implement these for proper key comparison)
}
