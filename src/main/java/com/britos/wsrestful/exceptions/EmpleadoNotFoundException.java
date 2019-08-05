package com.britos.wsrestful.exceptions;

public class EmpleadoNotFoundException extends RuntimeException {

    public EmpleadoNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
