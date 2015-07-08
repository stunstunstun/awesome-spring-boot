package com.jce.mvc.commons.util.encrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;

/**
 * <PRE>
 * Class/Interface Name : HMACSHA1
 * History
 *     1. JungMinHyeok(chujinnoon@joycity.com), 2011. 8. 12.
 * </PRE>
 * @brief HMACSHA1 형태로 signature 생성하기 위한 클래스
 * @date 2011. 8. 12.
 * @version 1.0.0
 * @author JungMinHyeok(chujinnoon@joycity.com)
 * @warning 
 */

public class HMACSHA1 {
	
	public static String getDigest(String data, String key) {

		try {
			Mac mac = Mac.getInstance("HmacSHA1");
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
			mac.init(signingKey);
			byte[] digest = mac.doFinal(data.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(digest);

		} catch (NoSuchAlgorithmException e) {
			System.err.println("Exception caught: " + e);
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			System.err.println("Exception caught: " + e);
			e.printStackTrace();
		} catch (IllegalStateException e) {
			System.err.println("Exception caught: " + e);
			e.printStackTrace();
		}
		return null;
	}
}
