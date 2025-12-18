package com.ingnum.rentalservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BonjourController {

    @GetMapping("/bonjour")
    public String bonjour() {
        return "bonjour";
    }

    @GetMapping("/")
    public String home() {
        return "RentalService fonctionne !";
    }

    @GetMapping("/call-php")
    public String callPhpService() {
        RestTemplate restTemplate = new RestTemplate();
        // On utilise le nom du service défini dans docker-compose.yml
        String response = restTemplate.getForObject("http://phpservice:80", String.class);
        return "Réponse du service PHP : " + response;
    }
}
