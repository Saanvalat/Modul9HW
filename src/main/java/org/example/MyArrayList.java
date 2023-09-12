package org.example;

import java.util.Objects;

public class MyArrayList {
    private Object[] myArray;
    private int size;
    protected transient int modCount = 0;




    // add(Object value) додає елемент в кінець
    public MyArrayList() {
        myArray = new Object[10];
        size = 0;
    }

    public void add(Object value) {
        if (size == myArray.length)
            myArray = grow();
        myArray[size] = value;
        size++;

    }

    private Object[] grow() {
        int newCapacity = myArray.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(myArray, 0, newArray, 0, size);
        return newArray;
    }


    //remove(int index) видаляє елемент із вказаним індексом
    public Integer remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = myArray;
        Integer oldValue = (Integer) es[index];
        fastRemove(es, index);

        return oldValue;
    }

    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }
    // clear() очищає колекцію

    public void clear() {
        modCount++;
        final Object[] es = myArray;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    //  size() повертає розмір колекції
    public int size() {
        return size;
    }

    // get(int index) повертає елемент за індексом
    public Integer get(int index) {
        Objects.checkIndex(index, size);
        return (Integer) myArray[index];
    }

    private Integer myArray(int i) {
        return null;
    }


}

