package com.linkshortener.apiservice.exception

class ShortLinkDuplicateException extends AppException {

    ShortLinkDuplicateException(String message) {
        super(message)
    }

    ShortLinkDuplicateException(String message, Throwable cause) {
        super(message, cause)
    }

}
