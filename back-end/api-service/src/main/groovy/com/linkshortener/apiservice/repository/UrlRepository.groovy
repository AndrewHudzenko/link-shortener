package com.linkshortener.apiservice.repository

import com.linkshortener.apiservice.data.model.Url
import org.springframework.data.mongodb.repository.MongoRepository

interface UrlRepository extends MongoRepository<Url, String> {

    Optional<Url> findByShortCode(String shortCode)

    boolean existsByShortCode(String shortCode)

}
