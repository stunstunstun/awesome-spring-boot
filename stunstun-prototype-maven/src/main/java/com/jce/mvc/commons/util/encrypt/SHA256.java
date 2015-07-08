package com.jce.mvc.commons.util.encrypt;

import java.security.MessageDigest;

import org.bouncycastle.util.encoders.Hex;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 12. 27.
 */
public class SHA256 {

	public static String crypt(String param) throws Exception {
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		sha.update(param.getBytes());
		byte[] digest = sha.digest();
		String encryptData = new String(Hex.encode(digest));
		return encryptData;
	}
}
