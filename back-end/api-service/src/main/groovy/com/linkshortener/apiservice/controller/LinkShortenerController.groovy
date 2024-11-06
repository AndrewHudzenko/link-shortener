package com.linkshortener.apiservice.controller

import com.linkshortener.apiservice.annotation.OpenApiCreateShortLink
import com.linkshortener.apiservice.service.LinkShortenerService
import groovy.util.logging.Slf4j
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@Tag(name = "Link Shortener", description = "API for working with short links")
class LinkShortenerController {

    private final LinkShortenerService linkShortenerService

    LinkShortenerController(LinkShortenerService linkShortenerService) {
        this.linkShortenerService = linkShortenerService
    }

    @OpenApiCreateShortLink
    @PostMapping("/api/v1/link/shorten")
    String createShortLink(@RequestParam(required = true, name = "originalLink") String originalLink) {
        log.info("LinkShortenerController: creatig short link for original link: ${originalLink}")
        linkShortenerService.createShortLink(originalLink)
    }

}
