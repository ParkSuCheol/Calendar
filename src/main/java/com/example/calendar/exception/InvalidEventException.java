package com.example.calendar.exception;

public class InvalidEventException extends RuntimeException{
    public InvalidEventException(String message){
        super(message);
    }
}
