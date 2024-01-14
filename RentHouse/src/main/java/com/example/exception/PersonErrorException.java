package com.example.exception;

public class PersonErrorException extends RuntimeException {
    public PersonErrorException(String message) {
        super(message);
    }
}