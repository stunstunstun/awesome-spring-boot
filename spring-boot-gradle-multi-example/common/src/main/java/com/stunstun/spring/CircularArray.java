package com.stunstun.spring;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author minhyeok
 */
public class CircularArray<T> implements Iterable<T>, Cloneable {

    private int head = 0;

    private T[] items;

    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    public T get(int index) {
        if (index < 0 || index >= items.length)
            throw new IndexOutOfBoundsException();
        return items[convert(index)];
    }

    public void set(int index, T value) {
        items[convert(index)] = value;
    }

    public void rotate(int shift) {
        head = convert(shift);
    }

    private int convert(int index) {
        return (head + index) % items.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator(this);
    }

    private class CircularArrayIterator<E> implements Iterator<E> {

        private int current = 0;

        private E[] items;

        public CircularArrayIterator(CircularArray<E> array) {
            items = array.items;
        }

        @Override
        public boolean hasNext() {
            return (current < items.length);
        }

        @Override
        public E next() {
            return items[convert(current++)];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : items) {
            sb.append(item == null ? "null" : item.toString());
            sb.append(" ");
        }
        return hashCode() + "@[" + sb.toString() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        CircularArray<?> that = (CircularArray<?>) o;
        if (head != that.head)
            return false;
        return Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        int result = head;
        return 31 * result + Arrays.hashCode(items);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
