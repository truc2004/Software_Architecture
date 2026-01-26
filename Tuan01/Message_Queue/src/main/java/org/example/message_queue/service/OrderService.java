package org.example.message_queue.service;

import org.example.message_queue.entity.Order;
import org.example.message_queue.producer.OrderProducer;
import org.example.message_queue.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repo;
    private final OrderProducer producer;

    public OrderService(OrderRepository repo, OrderProducer producer) {
        this.repo = repo;
        this.producer = producer;
    }

    public Order createOrder(String email) {

        //  Tạo đơn hàng
        Order order = new Order();
        order.setEmail(email);
        order.setStatus("CREATED");
        repo.save(order);

        System.out.println("✅ Order created: " + order.getId());

        // Đẩy job gửi email (KHÔNG đợi)
        producer.sendEmailJob(order.getId(), email);

        return order;
    }
}
