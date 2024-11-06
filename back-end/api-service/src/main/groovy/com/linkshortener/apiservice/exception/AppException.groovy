package com.linkshortener.apiservice.exception

class AppException extends RuntimeException {

    AppException(String message) {
        super(message)
    }

    AppException(String message, Throwable cause) {
        super(message, cause)
    }

}
