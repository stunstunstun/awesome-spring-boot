package com.stunstun.spring;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
public class LinkedListTests {

    private LinkedList list;

    @Before
    public void setup() {
        list = new LinkedList();
        list.add("A");
        list.add("B");
        System.out.println(list);
    }

    @Test
    public void testList() {
        list.add("C");
        System.out.println(list);
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo("A");
        assertThat(list.get(1)).isEqualTo("B");
        assertThat(list.get(2)).isEqualTo("C");

        list.add(0, "D");
        System.out.println(list);
        assertThat(list.size()).isEqualTo(4);

        list.add(list.size(), "E");
        System.out.println(list);
        assertThat(list.size()).isEqualTo(5);

        list.remove(2);
        System.out.println(list);
        assertThat(list.size()).isEqualTo(4);

        list.remove(0);
        System.out.println(list);
        assertThat(list.size()).isEqualTo(3);

        list.remove(list.size() - 1);
        System.out.println(list);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.indexOf("A")).isEqualTo(0);
        assertThat(list.indexOf("C")).isEqualTo(1);
    }

    @Test
    public void indexOf() {
        list.add(2, "C");
        System.out.println(list);
        assertThat(list.indexOf("A")).isEqualTo(0);
        assertThat(list.indexOf("B")).isEqualTo(1);
        assertThat(list.indexOf("C")).isEqualTo(2);
        assertThat(list.indexOf("D")).isEqualTo(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addIndexOutOfBoundsException() {
        list.add(2, "C");
        System.out.println(list);

        assertThat(list.size()).isEqualTo(3);
        list.add(4, "D");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIndexOutOfBoundsException() {
        list.add(2, "C");
        System.out.println(list);

        assertThat(list.size()).isEqualTo(3);
        list.remove(3);
    }
}
