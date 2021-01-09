package com.api.rest.exceptions;

public class EmpleadoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1767345213815977975L;

	public EmpleadoNotFoundException(Long id) {
        super("Error. No se encontro un empleado con el id: " + id);
    }

    public EmpleadoNotFoundException(Long id, Exception e) {
        super("Error. No se encontro un empleado con el id: " + id, e);
    }
}
