package com.stunstun.spring;

/**
 * @author minhyeok
 */
public interface Queue<E> {

    public void enqueue(E item);

    public E dequeue();

    public boolean isEmpty();

    public int size();

    public boolean contains(E item);
}
