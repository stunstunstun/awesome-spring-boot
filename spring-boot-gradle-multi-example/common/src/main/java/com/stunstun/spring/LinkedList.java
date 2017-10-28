package com.stunstun.spring;

/**
 * @author minhyeok
 */
public class LinkedList implements List {

    private Node head;

    private Node tail;

    private int size = 0;

    @Override
    public void add(Object item) {
        Node node = new Node(item);
        if (size == 0) {
            head = node;
            tail = node;
            node.next = head;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, Object item) {
        Node node = new Node(item);
        if (index == 0) {
            Node nextNode = getNode(index);
            head = node;
            node.next = nextNode;
        } else if (index == size()) {
            Node prevNode = getNode(index - 1);
            prevNode.next = node;
            tail = node;
        } else {
            Node prevNode = getNode(index - 1);
            Node nextNode = getNode(index);
            prevNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        return getNode(index).data;
    }

    private Node getNode(int index) {
        if (index < 0 || index > size() - 1)
            throw new IndexOutOfBoundsException();
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else if (index == size() - 1) {
            Node prevNode = getNode(index - 1);
            tail = prevNode;
        } else {
            Node nextNode = getNode(index + 1);
            Node prevNode = getNode(index - 1);
            prevNode.next = nextNode;
        }
        size--;
    }

    @Override
    public int indexOf(Object data) {
        Node node = head;
        for (int i = 0; i < size(); i++) {
            if (node.data.equals(data))
                return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        for (int i = 0; i < size(); i++) {
            sb.append(node.data);
            if (i != size() -1)
                sb.append(", ");
            node = node.next;
        }
        return String.format("[%s] HEAD = %s TAIL = %s", sb.toString(), head.data, tail.data);
    }

    private class Node {

        private Object data;

        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }
}

interface List {

    void add(Object item);

    void add(int index, Object item);

    Object get(int index);

    void remove(int index);

    int indexOf(Object data);

    int size();
}