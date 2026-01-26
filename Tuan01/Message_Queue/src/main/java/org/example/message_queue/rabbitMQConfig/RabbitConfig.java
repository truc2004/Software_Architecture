package org.example.message_queue.rabbitMQConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

@Configuration
public class RabbitConfig {

    public static final String QUEUE = "email_queue";

    @Bean
    public Queue emailQueue() {
        return new Queue(QUEUE, true);
    }
}
