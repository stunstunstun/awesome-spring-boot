package com.stunstun.spring;

import java.util.Stack;

/**
 * @author minhyeok
 */
public class TwoStackQueue<E> implements Queue<E> {

    private final Stack<E> in;

    private final Stack<E> out;

    public TwoStackQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    @Override
    public int size() {
        return in.size() + out.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return in.contains(o) || out.contains(o);
    }

    @Override
    public void enqueue(E e) {
        in.push(e);
    }

    @Override
    public synchronized E dequeue() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    @Override
    public String toString() {
        return String.format("size = %d, %s %s", size(), in.toString(), out.toString());
    }
}
