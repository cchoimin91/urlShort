package com.choimin.urlshort.exception;

public class NotExistUrlException extends RuntimeException {

    private String message;

    public NotExistUrlException(String message) {
        super(message);
    }
}
