package org.example;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;

    private Node<K, V>[] table;
    private int size;

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        table = new Node[capacity];
        size = 0;
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }
    // put(Object key, Object value) додає пару ключ + значення
    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newNode;
            }
        }
        size++;
    }
    //get(Object key) повертає значення (Object value) за ключем
    public V get(K key) {
        int index = hash(key);
        Node<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }
    //size() повертає розмір колекції
    public int size() {
        return size;
    }
    //clear() очищає колекцію
    public void clear() {
        table = new Node[table.length];
        size = 0;
    }
    //remove(Object key) видаляє пару за ключем
    public void remove(K key) {
        int index = hash(key);
        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
