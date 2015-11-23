package com.stunstun.spring.common.support;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public class CodecUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtils.class);
	
	private static final String ENCODING_TYPE = "UTF-8";
	private static final String MD5 = "MD5";
	private static final String SHA256 = "SHA-256";
	private static final String HMAC_MD5 = "HmacMD5";
	private static final String HMAC_SHA256 = "HmacSHA256";
	public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;

	private CodecUtils() {}
	
	public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
        	LOGGER.error(e.getMessage());
        }
    }
	
	public static byte[] toBinary(String data, String encodingType) {
		if (!Charset.isSupported(encodingType)) {
			throw new RuntimeException(encodingType + " is not supported encoding type");
		}
		return data.getBytes(Charset.forName(encodingType));
	}
	
	public static String toString(byte[] binary, String encodingType) {
		if (!Charset.isSupported(encodingType)) {
			throw new RuntimeException(encodingType + " is not supported encoding type");
		}
		return new String(binary, Charset.forName(encodingType));
	}
	
	public static byte[] toBinary(String data) {
		return toBinary(data, ENCODING_TYPE);
	}
	
	public static String toString(byte[] binary) {
		return toString(binary, ENCODING_TYPE);
	}
	
	public static String byteArrayToHex(byte[] binary) {
	    if (binary == null || binary.length == 0) {
	        return null;
	    }
	    StringBuffer sb = new StringBuffer(binary.length * 2);
	    String hexNumber = null;
	    for (int x = 0; x < binary.length; x++) {
	        hexNumber = "0" + Integer.toHexString(0xff & binary[x]);
	        sb.append(hexNumber.substring(hexNumber.length() - 2));
	    }
	    return sb.toString();
	}
	
	public static String readStreamToString(InputStream inputStream) throws IOException {
		BufferedInputStream bufferedInputStream = null;
        InputStreamReader reader = null;
        
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            reader = new InputStreamReader(bufferedInputStream);
            StringBuilder stringBuilder = new StringBuilder();

            final int bufferSize = DEFAULT_STREAM_BUFFER_SIZE;
            char[] buffer = new char[bufferSize];
           
            int n = 0;
            while ((n = reader.read(buffer)) != -1) {
                stringBuilder.append(buffer, 0, n);
            }
            return stringBuilder.toString();
        } finally {
            closeQuietly(bufferedInputStream);
            closeQuietly(reader);
        }
    }
	
	public static String md5hash(String data) {
		MessageDigest hash = null;
		try {
			hash = MessageDigest.getInstance(MD5);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(e.getMessage());
			return null;
		}

		hash.update(data.getBytes());
		byte[] digest = hash.digest();
		
		StringBuilder builder = new StringBuilder();
		for (int b : digest) {
			builder.append(Integer.toHexString((b >> 4) & 0xf));
			builder.append(Integer.toHexString((b >> 0) & 0xf));
		}
		return builder.toString();
	}
	
	public static String sha256hash(String data) {
		String hashedString = null;
		try {
			MessageDigest sh = MessageDigest.getInstance(SHA256);
			sh.update(data.getBytes());
			
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			hashedString = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(e.getMessage());
			hashedString = null;
		}
		return hashedString;
	}
	

	public static byte[] hmacMD5hash(String data, byte[] secret) {
		return hmacHash(data, secret, HMAC_MD5);
	}
	
	public static byte[] hmacSHA256hash(String data, byte[] secret) {
		return hmacHash(data, secret, HMAC_SHA256);
	}
	
	public static String hmacMD5hash(String data, String secret) {
		return Base64.encodeBase64String(hmacHash(data, secret, HMAC_MD5));
	}
	
	public static String hmacSHA256hash(String data, String secret) {
		return Base64.encodeBase64String(hmacHash(data, secret, HMAC_SHA256));
	}
	
	public static String RFC3986Encoder(String normal) throws UnsupportedEncodingException {
	   return URLEncoder.encode(normal, ENCODING_TYPE).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
	}
	
	public static String RFC3986Decoder(String normal) throws UnsupportedEncodingException {
	   return URLDecoder.decode(normal, ENCODING_TYPE);
	}
	
	public static String encodeBase64(String data) {
		byte[] dataBinary = null;
		try {
			dataBinary = data.getBytes(ENCODING_TYPE);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage());
		}
		return Base64.encodeBase64String(dataBinary);
	}
	
	public static String decodeBase64(String encodedData) {
		byte[] decodedResult = Base64.decodeBase64(encodedData);
		try {
			return new String(decodedResult, ENCODING_TYPE);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static String encodeUrlParameters(Map<String, Object> params) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (String key : params.keySet()) {
            if (!isFirst) sb.append('&');
            else isFirst = false;
            sb.append(RFC3986Encoder(key));
            sb.append('=');
            sb.append(RFC3986Encoder(params.get(key).toString()));
        }
        return sb.toString();
    }
	
	private static byte[] hmacHash(String data, byte[] secret, String algorithm) {
		Mac hmacSHA256 = null;
		try {
			hmacSHA256 = Mac.getInstance(algorithm);
		} catch (NoSuchAlgorithmException ex) {
			throw new RuntimeException("No such hash algorithm = " + algorithm);
		}

		SecretKeySpec secretKey = new SecretKeySpec(secret, algorithm);
		try {
			hmacSHA256.init(secretKey);
		} catch (InvalidKeyException ex) {
			throw new RuntimeException(ex.getMessage());
		}
		
		byte[] hashedData = hmacSHA256.doFinal(data.getBytes());
		LOGGER.info("Data[{}] Algorithm[{}] Hashed HEX[{}]", data, algorithm, byteArrayToHex(hashedData));
		return hashedData;
	}
	
	private static byte[] hmacHash(String data, String secret, String algorithm) {
		return hmacHash(data, secret.getBytes(), algorithm);
	}
}