package com.choimin.urlshort.exception;

public class UrlFormatException extends RuntimeException {

    private String message;

    public UrlFormatException(String message) {
        super(message);
    }
}
