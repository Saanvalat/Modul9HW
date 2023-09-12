package org.example;


import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> {
        Node<T> head;
        Node<T> tail;
        private int size;
        protected transient int modCount = 0;
        private Node<T> f;

    // Node
        static class Node<T> {
            T value;
            Node<T> next;
            Node<T> previous;

            public Node(T value) {
                this.value = value;
            }
        }


        //add(Object value) додає елемент в кінець
        public void add(T value) {
            Node<T> node = new Node<>(value);

            if (tail == null){
                head = node;
                tail = node;
        } else {
            tail.next = head;
            node.previous = tail;
            tail = head;
        }
        size++;
            modCount++;
    }

    //remove(int index) видаляє елемент із вказаним індексом
    public void remove(int index) {
        Objects.checkIndex(index, size);
        Node<T> nodeToRemove = getNodeAtIndex(index);
        unlink(nodeToRemove);
        modCount++;

    }

    private Node<T> getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    public T removeFirst() {
        final Node<T> f = head;
        if (head == null){
            throw new NoSuchElementException();
    }
        unlink(f);
        modCount++;
        return f.value;
    }
   private void unlink(Node<T> x) {
            final Node<T> next = x.next;
            final Node<T> prev = x.previous;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.previous = prev;
        }

       x.value = null;
       size--;
       modCount++;

    }
    private T unlinkFirst(int index) {
             final T element = f.value;
        final MyLinkedList.Node<T> next = f.next;
        f.value = null;
        f.next = null;
        head = next;
        if (next == null)
            tail = null;
        else
            next.previous = null;
        size--;
        modCount++;
        return element;
    }

    //    clear() очищає колекцію
    public void clear() {
            head = null;
            tail = null;
            size = 0;
    }


    //size() повертає розмір колекції
    public int size() {
        return size;
    }


    //get(int index) повертає елемент за індексом
    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }
}
