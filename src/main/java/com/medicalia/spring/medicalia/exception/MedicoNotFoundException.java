package com.medicalia.spring.medicalia.exception;

public class MedicoNotFoundException extends RuntimeException {


    public MedicoNotFoundException() {
        super("El medico no existe.");
    }
}
