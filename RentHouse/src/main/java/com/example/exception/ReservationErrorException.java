package com.example.exception;

public class ReservationErrorException extends RuntimeException{

    public ReservationErrorException(String message) {
        super(message);
    }
}
