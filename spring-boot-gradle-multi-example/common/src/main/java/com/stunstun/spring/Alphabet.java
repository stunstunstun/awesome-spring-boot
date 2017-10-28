package com.stunstun.spring;

import java.util.Arrays;

/**
 * @author minhyeok
 */
public class Alphabet {

    public static final int ALPHABET_COUNTS = 26;

    public static final char LAST_ALPHABET = 'z';

    public static int calculatedMappingCounts(String alphabets) throws AlphabetException {
        if (alphabets.length() > ALPHABET_COUNTS) {
            throw new AlphabetException("alphabets size is too long");
        }
        char[] chars = alphabets.toLowerCase().toCharArray();
        int[] counts = new int[ALPHABET_COUNTS];
        for (int i = 0; i < alphabets.length(); i++) {
            int countIndex = LAST_ALPHABET - chars[i];
            if (countIndex < 0 || countIndex > 26) {
                throw new AlphabetException("parameter have to be alphabets");
            }
            counts[countIndex] += 1;
        }
        return sum(counts);
    }

    private static int sum(int[] counts) {
        Arrays.sort(counts);
        int total = 0;
        for (int multipleNumber = ALPHABET_COUNTS; multipleNumber > 0; multipleNumber--) {
            int countIndex = multipleNumber - 1;
            if (counts[countIndex] == 0)
                break;
            total += counts[countIndex] * multipleNumber;
        }
        return total;
    }

}

class AlphabetException extends Exception {
    public AlphabetException(String message) {
        super(message);
    }
}
