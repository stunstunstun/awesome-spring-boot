package com.stunstun.spring;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author minhyeok
 */
public class ArrayQueue<E> implements Queue<E>, Serializable {

    private final E[] items;

    private int head;

    private int size;

    public ArrayQueue(int capacity) {
        if (capacity == 0)
            throw new IllegalArgumentException("Queue size can not be zero");
        this.items = (E[]) new Object[capacity];
        this.head = 0;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object item : items) {
            if (item.equals(o))
                return true;
        }
        return false;
    }

    @Override
    public synchronized void enqueue(E e) {
        if (size() == items.length)
            dequeue();
        items[(head + size++) % items.length] = e;
    }

    @Override
    public synchronized E dequeue() {
        if (size() == 0)
            return null;
        size -= 1;
        E result = items[head];
        head = (head + 1) % items.length;
        return result;
    }

    @Override
    public String toString() {
        return String.format("head = %d, size = %d, %s", head, size, Arrays.asList(items));
    }
}
