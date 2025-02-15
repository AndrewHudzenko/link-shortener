package com.linkshortener.apiservice.data.model

import groovy.transform.ToString
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDateTime

@ToString
@Document(collection = "Url")
class Url {
    @Id
    String id
    @CreatedDate
    LocalDateTime createdDateTime
    @LastModifiedDate
    LocalDateTime lastModifiedDateTime
    @Version
    Long version
    @Indexed(unique = true)
    String shortCode
    String originalUrl
    int clicks
}
