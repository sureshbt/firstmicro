package com.sureshmicro.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@AllArgsConstructor
@Component
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish (Object payload,String exchange,String routingkey) {

        log.info("Publish message using {} . payload {}",exchange,routingkey);
        amqpTemplate.convertAndSend(exchange,routingkey,payload);
        log.info("Done message using {} . payload {}",exchange,routingkey);



    }
}
