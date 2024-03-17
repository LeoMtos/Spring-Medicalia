package com.medicalia.spring.medicalia.exception;

public class UsuarioNotFoundException extends RuntimeException {


    public UsuarioNotFoundException() {
        super("El usuario ingresado no existe.");
    }
}
