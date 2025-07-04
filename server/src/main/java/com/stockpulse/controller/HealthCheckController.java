package com.stockpulse.controller;


import com.stockpulse.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @Autowired
    private HealthCheckService healthCheckService;


    @GetMapping
    public String healthCheck() {
        return healthCheckService.getApplicationHealth();
    }

}
