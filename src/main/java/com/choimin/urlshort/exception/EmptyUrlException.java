package com.choimin.urlshort.exception;

public class EmptyUrlException extends RuntimeException {

    private String message;

    public EmptyUrlException(String message) {
        super(message);
    }
}
