/**
 * 
 */
package com.stunstun.spring.common;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
@JsonInclude(Include.NON_NULL)
public class ResponseObject<T> extends ResponseHttpStatus implements Response {

	private T result;
	private int resultCode;
	
	public ResponseObject() {
		super();
	}
	
	public ResponseObject(HttpStatus status) {
		this(status, status.value(), status.getReasonPhrase());
	}
	
	public ResponseObject(HttpStatus status, String message) {
		this(status, status.value(), message);
	}
	
	public ResponseObject(HttpStatus status, int resultCode, String message) {
		super(status, message);
		this.resultCode = resultCode;
	}
	
	public ResponseObject(HttpStatus status, int resultCode, T result) {
		super(status);
		this.resultCode = resultCode;
		this.result = result;
	}
	
	public ResponseObject(T result) {
		this(HttpStatus.OK, RESULT_OK, result);
		if (result instanceof Throwable) {
			throw new RuntimeException("Throwable class does not parameter of ResponseObject(T result) constructor.");
		}
	}
	
	public ResponseObject(int resultCode, String message) {
		this(HttpStatus.OK, resultCode, message);
	}
	
	public T getResult() {
		return result;
	}
	
	@Override
	public int getResultCode() {
		return resultCode;
	}

	@Override
	public String getMessage() {
		return message;
	}
}