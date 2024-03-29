package com.medicalia.spring.medicalia.exception;

public class PacienteNotFoundException extends RuntimeException {


    public PacienteNotFoundException() {
        super("El paciente no existe.");
    }
}
