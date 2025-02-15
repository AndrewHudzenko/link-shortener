package com.linkshortener.apiservice.data.model

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.URL

class UrlRequest {
    @NotBlank(message = "URL cannot be empty")
    @URL(message = "Invalid URL format")
    String url
}
