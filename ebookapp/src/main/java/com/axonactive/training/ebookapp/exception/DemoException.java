package com.axonactive.training.ebookapp.exception;


import org.springframework.http.HttpStatus;

public class DemoException {
    private static final String USEREBOOK_NOT_FOUND_MSG_KEY = "UserEbookNotExisted";
    private static final String USEREBOOK_NOT_FOUND_MSG = "UserEbook Not Found";
    private static final String AUTHOR_NOT_FOUND_MSG_KEY = "AuthorNotExisted";
    private static final String AUTHOR_NOT_FOUND_MSG = "Author Not Found";
    private static final String PUBLISHER_NOT_FOUND_MSG_KEY = "PublisherNotExisted";
    private static final String PUBLISHER_NOT_FOUND_MSG = "Publisher Not Found";

    public static ResponseException notFound(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }

    public static ResponseException badRequest(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServerError(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseException UserEbookNotFound() {
        return notFound(USEREBOOK_NOT_FOUND_MSG_KEY, USEREBOOK_NOT_FOUND_MSG);
    }

    public static ResponseException AuthorNotFound() {
        return notFound(AUTHOR_NOT_FOUND_MSG_KEY, AUTHOR_NOT_FOUND_MSG);
    }

    public static ResponseException PublisherNotFound() {
        return notFound(PUBLISHER_NOT_FOUND_MSG_KEY, PUBLISHER_NOT_FOUND_MSG);
    }
}
