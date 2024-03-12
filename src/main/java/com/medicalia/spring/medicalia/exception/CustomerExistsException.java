package com.medicalia.spring.medicalia.exception;

public class CustomerExistsException extends RuntimeException {

    public CustomerExistsException() {
        super("El usuario ingresado ya se encuentra registrado.");
    }
}
