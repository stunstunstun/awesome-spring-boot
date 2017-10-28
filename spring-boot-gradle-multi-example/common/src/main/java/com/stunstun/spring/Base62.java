package com.stunstun.spring;
/**
 * @author minhyeok
 */
public class Base62 {

    private static final char[] CODECS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    private static final int RADIX = 62;

    private static final int MAX_SIZE = 8;

    private Base62() {}

    public static String encode(Long id) {
        char[] buffer = new char[MAX_SIZE];
        int charIndex = buffer.length;
        for ( ; id > 0; id = Long.divideUnsigned(id, RADIX)) {
            buffer[--charIndex] = CODECS[(int) Long.remainderUnsigned(id, RADIX)];
        }
        return new String(buffer, charIndex, buffer.length - charIndex);
    }
}
