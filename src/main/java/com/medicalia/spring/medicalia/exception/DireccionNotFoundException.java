package com.medicalia.spring.medicalia.exception;

public class DireccionNotFoundException extends RuntimeException {


    public DireccionNotFoundException() {
        super("La direccion del usuario no existe.");
    }
}
