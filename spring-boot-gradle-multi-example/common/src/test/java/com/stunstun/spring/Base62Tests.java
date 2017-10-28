package com.stunstun.spring;


import org.junit.Test;
import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author minhyeok
 */
public class Base62Tests {

    @Test
    public void base62() throws UnsupportedEncodingException {
        String encoded = Base62.encode(System.currentTimeMillis());
        assertThat(encoded.length()).isEqualTo(7);
    }
}
