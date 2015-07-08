package com.stunstun.spring.mvc.commons.util.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *  AES128 암/복호화 키 : 원하시는 값으로 변경 가능하나 반드시 16바이트 문자열이어야 합니다.
 *  *참고*주의* AES256 방식 -> 32바이트 키값 채용 -> jdk1.5 버전에 포함된 jre 암호화 라이브러리단에 길이 체크 버그가 있어 정상동작 하지 않습니다. 
 *  라이브러리 패치로 정상 사용가능하나 현재 상용서버들 라이브러리 패치를 진행할수 없으므로 128방식 사용합니다.
 * @author psme324 hye-jeong kim 2013.02.01
 */
public class AES{
    private static String defaultkey = "JCEaltjtlfwebdev";

   /**
     * hex to byte[] : 16진수 문자열을 바이트 배열로 변환한다.
     * @param hex    hex string
     * @return
     */
    public static byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() == 0) {
            return null;
        }

       byte[] ba = new byte[hex.length() / 2];
        for (int i = 0; i < ba.length; i++) {
            ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return ba;
    }

   /**
     * byte[] to hex : unsigned byte(바이트) 배열을 16진수 문자열로 바꾼다.
     * @param ba        byte[]
     * @return
     */
    public static String byteArrayToHex(byte[] ba) {
        if (ba == null || ba.length == 0) {
            return null;
        }

        StringBuffer sb = new StringBuffer(ba.length * 2);
        String hexNumber;
        for (int x = 0; x < ba.length; x++) {
            hexNumber = "0" + Integer.toHexString(0xff & ba[x]);

           sb.append(hexNumber.substring(hexNumber.length() - 2));
        }
        return sb.toString();
    }

   /**
     * AES 방식의 암호화
     * @param message
     * @return
     * @throws Exception
     */
    public static String encrypt(String message) throws Exception {
    	SecretKeySpec skeySpec = new SecretKeySpec(defaultkey.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] encrypted = cipher.doFinal(message.getBytes());
        return byteArrayToHex(encrypted);
    }

   /**
     * AES 방식의 복호화
     * @param message
     * @return
     * @throws Exception
     */
    public static String decrypt(String encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(defaultkey.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original = cipher.doFinal(hexToByteArray(encrypted));
        String originalString = new String(original);
        return originalString;
    }
}
