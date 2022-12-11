package com.big3anime.backend.exceptions;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
