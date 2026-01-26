package org.example.message_queue.producer;

import org.example.message_queue.rabbitMQConfig.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void sendEmail(String message) throws InterruptedException {

        System.out.println("📨 Receive job: " + message);

        // giả lập gửi email mất 3 giây
        Thread.sleep(3000);

        String[] data = message.split("\\|");
        String orderId = data[0];
        String email = data[1];

        System.out.println("✉️ Email sent to " + email +
                " for order " + orderId);
    }
}
