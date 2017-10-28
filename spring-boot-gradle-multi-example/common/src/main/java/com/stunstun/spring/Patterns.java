package com.stunstun.spring;

/**
 * @author minhyeok
 */
public class Patterns {

    private Patterns() {}

    public static boolean isBalanced(String str) {
        if ("".equals(str) || str == null)
            return false;
        if (str.length() == 1)
            return true;
        int divideRange = 2;
        while (divideRange <= str.length()) {
            if(str.length() % divideRange != 0) {
                divideRange++;
                continue;
            }
            String[] parts = split(str, divideRange++);
            if (isMatched(parts)) {
                return true;
            }
        }
        return false;
    }

    private static String[] split(String str, int divideRange) {
        int size = str.length() / divideRange;
        String[] strings = new String[divideRange];
        for (int i = 0; i < divideRange; i++) {
            strings[i] = str.substring(i * size, (i + 1) * size);
        }
        return strings;
    }

    private static boolean isMatched(String[] parts) {
        for (int i = 1; i < parts.length; i++) {
            if (!parts[i].equals(parts[0]))
                return false;
        }
        return true;
    }
}