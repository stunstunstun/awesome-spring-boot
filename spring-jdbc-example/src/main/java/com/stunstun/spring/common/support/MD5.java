package com.stunstun.spring.common.support;

/** MD5 형태로 random String 생성 
 * input : timestamp
 * 
 * @brief com.jce.lib.openapi.util.MD5
 */

import java.security.*;

public class MD5 {
	
	public static String md5( String str ) throws Exception	{
		if ( str == null ){ return ""; }
		byte[] digest = MessageDigest.getInstance("MD5").digest( str.getBytes() );
		StringBuffer sb = new StringBuffer();
		for( int i = 0; i < digest.length; i++ ) {
			sb.append( Integer.toString( ( digest[i] & 0xf0) >> 4, 16 ) );
			sb.append( Integer.toString( digest[i] & 0x0f, 16 ) );
		}
		return sb.toString();
	}
}