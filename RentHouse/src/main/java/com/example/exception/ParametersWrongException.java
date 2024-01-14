package com.example.exception;

public class ParametersWrongException extends RuntimeException{

    public ParametersWrongException() {
    }

    public ParametersWrongException(String message) {
        super(message);
    }
}
