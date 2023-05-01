package com.sureshmicro.customer;
import com.sureshmicro.client.fraud.FraudCheckReponse;

import com.sureshmicro.client.fraud.FraudClient;
import com.sureshmicro.client.fraud.NotificationClient;
import com.sureshmicro.client.fraud.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService
{

    private final RestTemplate restTemplate;

    private  final CustomerRepository customerRepository;

    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
       // FraudCheckReponse fraudCheckReponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
         //       FraudCheckReponse.class,
           //     customer.getId()); changed to feign client

        FraudCheckReponse fraudCheckReponse =fraudClient.isFraudster(customer.getId());

        if (fraudCheckReponse.isFraudster()) {
            throw new IllegalStateException("validation failed");
        }
        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, welcome to kirikalan magic show...",
                                customer.getFirstName())
                )
        );

    }
}
