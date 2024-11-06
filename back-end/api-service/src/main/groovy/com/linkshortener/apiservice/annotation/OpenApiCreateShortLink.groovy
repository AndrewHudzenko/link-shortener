package com.linkshortener.apiservice.annotation

import com.linkshortener.apiservice.data.model.UrlMapping
import com.linkshortener.apiservice.exception.AppException
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * Annotation for OpenAPI documentation of create short link endpoint
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(
        summary = "Create short link",
        description = "Create short link for original link"
)
@ApiResponses([
        @ApiResponse(
                responseCode = "200",
                description = "Short link successfully created",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = UrlMapping)
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "Bad request",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = AppException)
                )
        )
])
@interface OpenApiCreateShortLink {}
