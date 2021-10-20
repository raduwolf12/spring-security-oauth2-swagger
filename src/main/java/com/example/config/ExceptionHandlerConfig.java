package com.example.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

	private Logger loggerIngo = LogManager.getLogger(ExceptionHandlerConfig.class);

//	@Override
//	protected ResponseEntity<Object> handleMethodNoSuchElementException(){
//		
//	}

}
