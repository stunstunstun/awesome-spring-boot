/**
 * 
 */
package com.stunstun.spring.common;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public interface Response {
	public static final int RESULT_OK = 0;
	public static final String RESULT_OK_STRING = "0";
	public static final String RESULT_OK_MESSAGE = "OK";
	
	public static final int RESULT_INVALID_REQUEST = 400;
	public static final int RESULT_UNSUPPORTED_PG_PROVIDER = 1001;
	public static final int RESULT_AUTHENTICATION_FAILED = 2001;
	public static final int RESULT_INVALID_SIGNATURE = 2002;
	public static final int RESULT_UNCERTIDIED_POS = 2003;
	public static final int RESULT_FAILED_PG_APPROVAL = 3001;
	public static final int RESULT_FAILED_VAN_APPROVAL = 4001;
	
	public int getResultCode();
	public String getMessage();
}