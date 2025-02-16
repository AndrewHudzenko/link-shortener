package com.linkshortener.apiservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class ApiServiceApplication {

    static void main(String[] args) {
        SpringApplication.run(ApiServiceApplication, args)
    }

}
