package org.example.message_queue.controller;

import org.example.message_queue.entity.Order;
import org.example.message_queue.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public String createOrder(@RequestParam String email) {
        Order order = service.createOrder(email);
        return "Order created successfully. OrderId = " + order.getId();
    }
}
