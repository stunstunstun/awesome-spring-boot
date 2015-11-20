package com.stunstun.spring.common.support;

/**
 * <PRE>
 * Class/Interface Name : RFC3986Encoder
 * History
 *     1. JungMinHyeok(chujinnoon@joycity.com), 2011. 7. 12.
 * </PRE>
 * @brief RFC3986Encoder 형태로 인코딩 하기 위한 함수  
 * @date 2011. 7. 12.
 * @version 1.0.0
 * @author JungMinHyeok(chujinnoon@joycity.com)
 * @warning 
 */

import java.net.URLEncoder;


public class RFC3986Encoder {

	public static String encode(String arg0) {
		
	   //return URLEncoder.encode(original, "utf-8");
	   //fixed: to comply with RFC-3986
		
	   String tmp = null;
	   try {
		   tmp = URLEncoder.encode(arg0, "utf-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
	   }catch(Exception e) {
		   
	   }
	   return tmp;	   
	}
}
