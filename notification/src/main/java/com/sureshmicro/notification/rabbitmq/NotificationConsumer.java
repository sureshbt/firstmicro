package com.sureshmicro.notification.rabbitmq;

import com.sureshmicro.client.fraud.NotificationRequest;
import com.sureshmicro.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest){
        log.info("Consumtion done");
        log.info("Consumed {} from queue",notificationRequest);
        notificationService.send(notificationRequest);

    }

}
