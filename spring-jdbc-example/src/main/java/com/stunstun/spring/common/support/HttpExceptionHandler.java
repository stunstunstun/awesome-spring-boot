/**
 * 
 */
package com.stunstun.spring.common.support;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stunstun.spring.common.Response;
import com.stunstun.spring.common.ResponseObject;

/**
 * @author stunstun
 *
 */
@Controller
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE - 100)
public class HttpExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<Response> handle(MethodArgumentNotValidException ex) {
		return new ResponseEntity<Response>(new ResponseObject(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}	
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
    public ResponseEntity<Response> handle(HttpMessageNotReadableException ex) {
		return new ResponseEntity<Response>(new ResponseObject(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler({HttpMediaTypeNotSupportedException.class, HttpMediaTypeNotAcceptableException.class})
	@ResponseBody
	public ResponseEntity<Response> handle(HttpMediaTypeException ex) {
		return new ResponseEntity<Response>(new ResponseObject(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	public ResponseEntity<Response> handle(HttpRequestMethodNotSupportedException ex) {
		return new ResponseEntity<Response>(new ResponseObject(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ResponseEntity<Response> handle(Throwable ex) {
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		return new ResponseEntity<Response>(new ResponseObject(httpStatus.getReasonPhrase()), httpStatus);
	}
	
	@RequestMapping(value = "/not_found", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response> notFound() {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		return new ResponseEntity<Response>(new ResponseObject(httpStatus.getReasonPhrase()), httpStatus);
	}
}
