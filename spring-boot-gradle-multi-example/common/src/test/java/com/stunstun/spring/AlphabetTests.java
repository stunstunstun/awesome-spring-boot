package com.stunstun.spring;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
public class AlphabetTests {

    @Test
    public void tests() throws AlphabetException {
        assertThat(Alphabet.calculatedMappingCounts("a")).isEqualTo(26);
        assertThat(Alphabet.calculatedMappingCounts("ABbCcc")).isEqualTo(152);
        assertThat(Alphabet.calculatedMappingCounts("abcdefghijklmnopqrstuvwxyz")).isEqualTo(351);
    }

    @Test(expected = AlphabetException.class)
    public void exceptions() throws AlphabetException {
        assertThat(Alphabet.calculatedMappingCounts("")).isEqualTo(0);
        assertThat(Alphabet.calculatedMappingCounts("A*bCcc")).isEqualTo(152);
    }
}
