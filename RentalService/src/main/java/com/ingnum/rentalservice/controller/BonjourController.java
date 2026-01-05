package com.ingnum.rentalservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class BonjourController {

    private static final Logger logger = LoggerFactory.getLogger(BonjourController.class);

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    @GetMapping("/")
    public String home() {
        return "RentalService fonctionne !";
    }

    @GetMapping("/bonjour")
    public String bonjourSimple() {
        return "bonjour";
    }

    @GetMapping("/customer/{name}")
    public String bonjour(@PathVariable String name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = customerServiceUrl + "/customers/" + name + "/address";
        logger.info("Requesting URL: " + url);
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }
}
