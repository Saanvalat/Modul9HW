package org.example;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);

        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
        System.out.println("___________________________");





        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
           }
        System.out.println("___________________________");



        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);

        for (int i = 0; i < myQueue.size(); i++) {
            System.out.println(myQueue.poll());
        }
        System.out.println("___________________________");

        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);


        for (int i = 0; i < myStack.peek(); i++) {
            System.out.println(myStack.peek());
        }
        System.out.println("___________________________");

        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("one", 0);
        myHashMap.put("two", 1);
        myHashMap.put("three", 2);
        myHashMap.put("four", 3);
        myHashMap.put("five", 4);

        System.out.println(myHashMap.get("five"));


    }
}