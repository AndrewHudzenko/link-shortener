package com.linkshortener.apiservice.service

import com.linkshortener.apiservice.data.model.UrlMapping
import com.linkshortener.apiservice.exception.ShortLinkDuplicateException
import com.linkshortener.apiservice.repository.UrlMappingRepository
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

@Slf4j
@Service
class LinkShortenerService {

    private static final String ALPHABET = (('A'..'N') + ('P'..'Z') + ('a'..'k') + ('m'..'z') + ('2'..'9')).join()
    private static final int SHORT_LINK_LENGTH = 6
    private static final int GENERATION_MAX_ATTEMPTS = 5

    private final UrlMappingRepository urlMappingRepository

    LinkShortenerService(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository
    }

    /**
     * Method to create a short link for original link
     * @param originalLink original link
     * @return short link
     */
    String createShortLink(String originalLink) {
        log.debug("LinkShortenerService: creatig short link for original link: ${originalLink}")
        validateUrl(originalLink)

        String shortLink = generateUniqueShortLink()
        UrlMapping urlMapping = new UrlMapping(
                createdDate: new Date(),
                lastModifiedDate: new Date(),
                originalLink: originalLink,
                shortLink: shortLink)

        UrlMapping savedUrlMapping = urlMappingRepository.save(urlMapping)
        savedUrlMapping.shortLink
    }

    /**
     * Method to generate unique short link
     * @return unique short link
     * @return short link
     */
    private String generateUniqueShortLink() {
        int failedAttempts = 0
        String shortLink = (1..SHORT_LINK_LENGTH).collect { ALPHABET[new Random().nextInt(ALPHABET.length())] }.join()
        if (urlMappingRepository.findByShortLink(shortLink).isPresent()) {
            if (failedAttempts < GENERATION_MAX_ATTEMPTS) {
                failedAttempts++
                return generateUniqueShortLink()
            } else {
                throw new ShortLinkDuplicateException("Failed to generate unique short link, max unique attempts reached")
            }
        }
        shortLink
    }

    /**
     * Method to validate URL
     * @param url URL to validate
     * @throws IllegalArgumentException if URL is invalid
     * @return true if URL is valid
     * @return false if URL is invalid
     */
    private static void validateUrl(String url) {
        log.debug("LinkShortenerService: validating URL: ${url}")
//        try {
//            def urlObj = new URL(url)
//            if (!urlObj.protocol.toLowerCase().startsWith("http")) {
//                throw new IllegalArgumentException("Only HTTP(S) protocols are supported")
//            }
//        } catch (MalformedURLException e) {
//            throw new IllegalArgumentException("Invalid URL format", e)
//        }
    }

}
