package com.britos.wsrestful.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }

    public EmployeeNotFoundException(Long id, Exception e) {
        super("Could not find employee " + id, e);
    }
}
