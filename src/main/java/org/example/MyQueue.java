package org.example;


import java.util.NoSuchElementException;

public class MyQueue<T> {
    private Node head;
    private Node tail;
    private int size;


    private static class Node<T> {

        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }


   // add(Object value) додає елемент в кінець

    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    // clear() очищає колекцію
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
   // size() повертає розмір колекції
    public int size(){
        return size;
    }

    // peek() повертає перший елемент з черги
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) head.value;
    }
   // poll() повертає перший елемент з черги і видаляє його з колекції
    public T poll(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T value = (T) head.value;
        head = head.next;
        size--;
        if (isEmpty()){
            tail = null;
        }
        return value;
    }


    public boolean isEmpty(){
        return size == 0;
    }
}
