package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

 

@ControllerAdvice
public class RoleNotFoundExceptionMapper {

	
	@ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<?>resourceNotFoundHandling(RoleNotFoundException exception,WebRequest request)
    {
        ExceptionMessage errorDetails = new ExceptionMessage(exception.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
        
        
    }
    
	

}
