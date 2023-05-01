package com.sureshmicro.client.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping("api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);
}
