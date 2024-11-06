package com.linkshortener.apiservice.data.model

import groovy.transform.ToString
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@ToString
@Document(collection = "urlMapping")
class UrlMapping {
    @Id
    String id
    @CreatedDate
    @Indexed(background = true, direction = IndexDirection.DESCENDING)
    Date createdDate
    @LastModifiedDate
    @Indexed(background = true, direction = IndexDirection.DESCENDING)
    Date lastModifiedDate
    @Version
    Long version
    @Indexed(unique = true)
    String shortLink
    String originalLink
}
