package com.sureshmicro.client.fraud;
public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}