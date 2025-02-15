package com.linkshortener.apiservice.service

import com.linkshortener.apiservice.data.model.Url
import com.linkshortener.apiservice.repository.UrlRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import java.time.LocalDateTime

@Slf4j
@Service
class UrlService {

    private final UrlRepository urlRepository
    private final Random random

    @Value('${app.url.length:6}')
    private int shortCodeLength

    UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository
        this.random = new Random()
    }

    /**
     * Method to create a short URL
     * @param originalUrl
     * @return Url
     */
    Url createShortUrl(String originalUrl) {
        String shortCode = generateUniqueShortCode()

        Url url = new Url()
        url.setOriginalUrl(originalUrl)
        url.setShortCode(shortCode)
        url.setCreatedDateTime(LocalDateTime.now())
        url.setLastModifiedDateTime(LocalDateTime.now())
        url.setClicks(0)

        return urlRepository.save(url)
    }

    /**
     * Method to get the original URL from the short code
     * @param shortCode
     * @return Url
     */
    Url getOriginalUrl(String shortCode) {
        return urlRepository.findByShortCode(shortCode)
                .map(url -> {
                    url.setClicks(url.getClicks() + 1)
                    return urlRepository.save(url)
                })
                .orElseThrow(() -> new RuntimeException("URL not found"))
    }

    /**
     * Method to generate a unique short code
     * @return String
     */
    private String generateUniqueShortCode() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        StringBuilder shortCode
        do {
            shortCode = new StringBuilder()
            for (int i = 0; i < shortCodeLength; i++) {
                shortCode.append(chars.charAt(random.nextInt(chars.length())))
            }
        } while (urlRepository.existsByShortCode(shortCode.toString()))

        return shortCode.toString()
    }

}
