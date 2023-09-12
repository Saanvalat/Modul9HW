package org.example;

import java.util.NoSuchElementException;

public class MyStack <T> {
    private Node head;
    private int size;



    private static class Node<T> {

        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
//    push(Object value) додає елемент в кінець
public void push(T value) {
    Node<T> node = new Node<>(value);
    node.next = head;
    head = node;
    size++;
}

//    remove(int index) видаляє елемент за індексом

    public int remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            pop();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index-1; i++) {
                current = current.next;
                }
            current.next = current.next.next;
            size--;
        }
        return index;
    }


    //    clear() очищає колекцію
public void clear(){
    head = null;
    size = 0;
}
//    size() повертає розмір колекції
public int size(){
    return size;
}

//    peek() повертає перший елемент стеку
    public T peek() {
    if (isEmpty()) {
        throw new NoSuchElementException();
    }
    return (T) head.value;
}

    private boolean isEmpty() {
        return size == 0;
    }
//    pop() повертає перший елемент стеку та видаляє його з колекції
    private T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T value = (T) head.value;
        head = head.next;
        size--;
        return value;
        }


}
