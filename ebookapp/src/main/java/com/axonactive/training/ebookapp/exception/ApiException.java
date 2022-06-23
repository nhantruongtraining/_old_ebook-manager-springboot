package com.axonactive.training.ebookapp.exception;


import org.springframework.http.HttpStatus;

public class ApiException {
    private static final String USEREBOOK_NOT_FOUND_MSG_KEY = "UserEbookNotExisted";
    private static final String USEREBOOK_NOT_FOUND_MSG = "UserEbook Not Found";
    private static final String AUTHOR_NOT_FOUND_MSG_KEY = "AuthorNotExisted";
    private static final String AUTHOR_NOT_FOUND_MSG = "Author Not Found";
    private static final String PUBLISHER_NOT_FOUND_MSG_KEY = "PublisherNotExisted";
    private static final String PUBLISHER_NOT_FOUND_MSG = "Publisher Not Found";
    private static final String EBOOK_NOT_FOUND_MSG_KEY = "EbookNotExisted";
    private static final String EBOOK_NOT_FOUND_MSG = "Ebook Not Found";
    private static final String CONTRIBUTOR_NOT_FOUND_MSG_KEY = "ContributorNotExisted";
    private static final String CONTRIBUTOR_NOT_FOUND_MSG = "Contributor Not Found";
    private static final String LANGUAGE_NOT_FOUND_MSG_KEY = "LanguageNotExisted";
    private static final String LANGUAGE_NOT_FOUND_MSG = "Language Not Found";

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

    public static ResponseException EbookNotFound() {
        return notFound(EBOOK_NOT_FOUND_MSG_KEY, EBOOK_NOT_FOUND_MSG);
    }

    public static ResponseException ContributorNotFound() {
        return notFound(CONTRIBUTOR_NOT_FOUND_MSG_KEY, CONTRIBUTOR_NOT_FOUND_MSG);
    }

    public static ResponseException LanguageNotFound() {
        return notFound(LANGUAGE_NOT_FOUND_MSG_KEY, LANGUAGE_NOT_FOUND_MSG);
    }
}
