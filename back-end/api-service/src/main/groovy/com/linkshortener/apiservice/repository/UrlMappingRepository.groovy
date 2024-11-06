package com.linkshortener.apiservice.repository

import com.linkshortener.apiservice.data.model.UrlMapping
import org.springframework.data.mongodb.repository.MongoRepository

interface UrlMappingRepository extends MongoRepository<UrlMapping, String> {

    Optional<UrlMapping> findByShortLink(String shortLink)

}
