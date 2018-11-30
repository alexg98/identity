package wavy.global.identity.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import wavy.global.identity.utilities.IdentityRuntimeException;
import wavy.global.identity.utilities.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    
    @ExceptionHandler({Exception.class, RuntimeException.class, Throwable.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getMessage(), 
        		new HttpHeaders(), HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler({IdentityRuntimeException.class })
    protected ResponseEntity<Object> handleBscRuntimeExcepcion(IdentityRuntimeException ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound() {
        return String.valueOf(HttpStatus.NOT_FOUND.value());
    }
}
