package com.stunstun.spring;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
public class CircularArrayTests {

    private CircularArray<String> array;

    @Before
    public void setup() {
        array = new CircularArray<String>(4);
    }

    @Test
    public void setAndGet() {
        array.set(0, "Kim");
        String name = (String) array.get(0);
        assertThat(name).isEqualTo("Kim");
    }

    @Test
    public void rotateAndGet() {
        array.set(0, "Kim");
        array.set(1, "Jung");
        array.set(2, "Park");
        array.set(3, "Lee");

        array.rotate(3);

        String name = (String) array.get(0);
        assertThat(name).isEqualTo("Lee");
    }

    @Test
    public void forEach() {
        array.set(0, "Kim");
        array.forEach(str -> System.out.println(str));
    }

    @Test
    public void iterator() {
        array.set(0, "Kim");
        array.set(1, "Kim");
        array.set(2, "Kim");
        array.set(3, "Kim");

        Iterator<String> iterator = array.iterator();
        int loops = 0;
        while (iterator.hasNext()) {
            String name = iterator.next();
            assertThat(name).isNotNull();
            loops++;
        }
        assertThat(loops).isEqualTo(4);
    }

    @Test
    public void rotate() {
        array.set(0, "Kim");
        array.set(1, "Jung");
        array.set(2, "Park");
        array.set(3, "Lee");

        array.rotate(3);

        assertThat(array.get(0)).isEqualTo("Lee");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getButIndexCouldNotBeNegative() {
        array.set(0, "Kim");
        array.rotate(5);
        String name = (String) array.get(-1);
        assertThat(name).isEqualTo("Kim");
    }
}
