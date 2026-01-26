package org.example.message_queue.producer;

import org.example.message_queue.rabbitMQConfig.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendEmailJob(Long orderId, String email) {
        String message = orderId + "|" + email;
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE, message);

        System.out.println("Push email job to queue: " + message);
    }
}
