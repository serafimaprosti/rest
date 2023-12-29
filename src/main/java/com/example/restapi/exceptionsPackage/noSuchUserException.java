package com.example.restapi.exceptionsPackage;

public class noSuchUserException extends RuntimeException {

    public noSuchUserException(String message) {
        super(message);
    }
}
