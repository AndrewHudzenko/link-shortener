package com.linkshortener.apiservice.controller

import groovy.util.logging.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
class HealthCheckController {

    @GetMapping("/health")
    ResponseEntity<String> healthCheck() {
        log.info("HealthCheckController: check api-service status")
        return ResponseEntity.ok("Service is up and running");
    }

}
