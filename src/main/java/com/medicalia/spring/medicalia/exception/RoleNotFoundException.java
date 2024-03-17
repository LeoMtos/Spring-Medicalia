package com.medicalia.spring.medicalia.exception;

public class RoleNotFoundException extends RuntimeException {


    public RoleNotFoundException() {
        super("El ROLE no es valido.");
    }
}
