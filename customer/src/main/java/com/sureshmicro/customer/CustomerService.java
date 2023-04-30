package com.sureshmicro.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService
{

    private final RestTemplate restTemplate;

    private  final CustomerRepository customerRepository;
    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckReponse fraudCheckReponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckReponse.class,
                customer.getId());
        if (fraudCheckReponse.isFraudster()) {
            throw new IllegalStateException("validation failed");


        }
    }
}
