package com.example.CompositeKey.controller;

import com.example.CompositeKey.model.OrderItem;
import com.example.CompositeKey.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return ResponseEntity.ok(orderItems);
    }

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        if (orderItem == null) {
            return ResponseEntity.badRequest().build();
        }
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrderItem);
    }
}
