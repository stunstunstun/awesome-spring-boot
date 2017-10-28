package com.stunstun.spring;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
public class PatternsTests {

    @Test
    public void iterative() {
        assertThat(Patterns.isBalanced("a")).isTrue();
        assertThat(Patterns.isBalanced("aaa")).isTrue();
        assertThat(Patterns.isBalanced("abcabc")).isTrue();
        assertThat(Patterns.isBalanced("ababab")).isTrue();

        assertThat(Patterns.isBalanced("")).isFalse();
        assertThat(Patterns.isBalanced("ab")).isFalse();
        assertThat(Patterns.isBalanced("ababc")).isFalse();
    }
}
