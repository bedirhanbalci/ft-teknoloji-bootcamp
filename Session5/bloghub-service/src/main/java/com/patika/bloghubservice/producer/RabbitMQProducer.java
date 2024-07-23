package com.patika.bloghubservice.producer;

import com.patika.bloghubservice.config.RabbitMQProducerConfig;
import com.patika.bloghubservice.dto.producer.SendEmailMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQProducer {

    private final AmqpTemplate rabbitTemplate;

    private final RabbitMQProducerConfig rabbitMQProducerConfig;

    public void sendEmail(SendEmailMessage sendEmailMessage) {
        rabbitTemplate.convertAndSend(rabbitMQProducerConfig.getExchange(), rabbitMQProducerConfig.getRoutingKey(), sendEmailMessage);

        log.info("message kuyruğa gönderildi. kuyruk:{}, message: {}", rabbitMQProducerConfig.getQueueName(), sendEmailMessage);
    }
}
