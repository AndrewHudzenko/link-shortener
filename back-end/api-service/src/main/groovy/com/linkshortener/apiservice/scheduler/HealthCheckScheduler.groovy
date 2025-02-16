package com.linkshortener.apiservice.scheduler

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class HealthCheckScheduler {
    private final RestTemplate restTemplate

    HealthCheckScheduler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate
    }

    @Value('${api-service.base-url}')
    private String baseUrl

    // every 10 minutes
    @Scheduled(fixedRate = 600000, initialDelay = 0)
    void performHealthCheck() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/health", String.class)
            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Service is healthy")
            }
        } catch (Exception e) {
            System.out.println("Health check failed: " + e.getMessage())
        }
    }

}
