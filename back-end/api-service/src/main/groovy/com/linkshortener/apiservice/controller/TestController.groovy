package com.linkshortener.apiservice.controller

import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/api/v1/test")
@CrossOrigin(origins = "http://localhost:5173")
class TestController {

    @GetMapping("/short-link")
    String shortLink(@RequestParam("link") String link) {
        log.info("TestController: processing link: $link")
        return "short-link: $link"
    }
}
