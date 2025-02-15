package com.linkshortener.apiservice.controller

import com.linkshortener.apiservice.annotation.OpenApiCreateShortLink
import com.linkshortener.apiservice.data.model.Url
import com.linkshortener.apiservice.data.model.UrlRequest
import com.linkshortener.apiservice.service.UrlService
import groovy.util.logging.Slf4j
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.view.RedirectView

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "Url Shortener", description = "API for URL shortening")
class UrlController {

    private final UrlService urlService

    UrlController(UrlService urlService) {
        this.urlService = urlService
    }

    @OpenApiCreateShortLink
    @PostMapping("/shorten")
    ResponseEntity<Url> shortenUrl(@RequestBody @Valid UrlRequest request) {
        Url url = urlService.createShortUrl(request.url)
        return new ResponseEntity<>(url, HttpStatus.CREATED)
    }

    @GetMapping("/{shortCode}")
    RedirectView redirectToOriginalUrl(@PathVariable(name = "shortCode") String shortCode) {
        Url url = urlService.getOriginalUrl(shortCode)
        return new RedirectView(url.getOriginalUrl())
    }

}
