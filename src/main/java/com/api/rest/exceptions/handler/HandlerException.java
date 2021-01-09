package com.api.rest.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.api.rest.exceptions.EmpleadoNotFoundException;

@ControllerAdvice
public class HandlerException{

	@ResponseBody
	@ExceptionHandler(EmpleadoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String empleadoNotFoundHandler(EmpleadoNotFoundException ex) {
		return ex.getMessage();
	}
}