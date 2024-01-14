package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ParametersWrongException.class)
    public String errorCommon() {
        return "error_page";
    }

   @ExceptionHandler(PersonErrorException.class)
    public String errorPerson() {
       return "error_person_page";
   }

   @ExceptionHandler(ReservationErrorException.class)
    public String errorReservation() {
        return "error_reservation_page";
    }


}
