package com.example.CompositeKey.repository;
import com.example.CompositeKey.model.OrderItem;
import com.example.CompositeKey.model.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId>{

}
