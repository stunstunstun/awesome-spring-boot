package com.stunstun.spring.web.support;

import com.stunstun.spring.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author minhyeok
 */
@ControllerAdvice
public class HttpExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpExceptionHandler.class);

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        HttpStatus status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        return new ResponseEntity<>(status.getReasonPhrase(), status);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status.getReasonPhrase(), status);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status.getReasonPhrase(), status);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(status.getReasonPhrase(), status);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity handleException(Throwable ex) {
        LOGGER.error(ex.getMessage());
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(status.getReasonPhrase(), status);
    }
}