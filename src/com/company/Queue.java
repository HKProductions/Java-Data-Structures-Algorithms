package com.company;

public class Queue {
    class Node{
        int val;
        Node next;

        Node(){this.next = null;}

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int length;

    Queue(){
        head = null;
        tail = null;
        length = 0;
    }

    /*
        O(1) Time Complexity
        O(N) Space Complexity

        This is my implementation of inserting values into a queue utilizing a linked list
     */
    public void push(int val){
        Node newNode = new Node(val);

        if(length == 0){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    /*
        O(1) Time and Space Complexity

        This is my implementation of the pop functionality of queues utilizing linked list
     */
    public int pop(){
        int res;

        if(length == 0)
            throw new NullPointerException("Queue is empty can't pop any values");

        res = head.val;
        if(length == 1 || head == tail){
            head = null;
            tail = null;
        }
        else
            head = head.next;
        length--;

        return res;
    }

    /*
        O(1) Time and Space Complexity

        This is my implementation of the peek functionality of the queue utilizing linked list
     */
    public int peek(){
        if(length == 0)
            return -1;

        return head.val;
    }
}
