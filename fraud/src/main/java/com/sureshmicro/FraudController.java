package com.sureshmicro;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;
    @GetMapping(path = "{customerId}")
    public FraudCheckReponse isFraudster(@PathVariable("customerId") Integer customerID)
    {
    boolean isFradulentCustomer = fraudCheckService.isFradulentCustomer(customerID);
    log.info("Fraud check done for {}",customerID);

return new FraudCheckReponse(isFradulentCustomer);

    }
}
