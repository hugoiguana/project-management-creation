package com.hugo.mota.projectmanagementcreation.exception.handler;

import com.hugo.mota.projectmanagementcreation.exception.BusinessException;
import com.hugo.mota.projectmanagementcreation.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(StandardError.get(HttpStatus.NOT_FOUND, objectNotFoundException));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<StandardError> businessException(BusinessException businessException, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(StandardError.get(HttpStatus.INTERNAL_SERVER_ERROR, businessException));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationError validationError = ValidationError.get(HttpStatus.BAD_REQUEST, "Validation Error");
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            validationError.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }

    /*

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(StandardError.get(HttpStatus.FORBIDDEN, e));
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrityException(DataIntegrityException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(StandardError.get(HttpStatus.BAD_REQUEST, e));
    }
    */
}
