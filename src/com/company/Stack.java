package com.company;

public class Stack {
    class Item{
        int val;
        Item next;

        Item(){this.next = null;}

        Item(int val){
            this.val = val;
            this.next = null;
        }
    }

    private Item head;
    private Item tail;
    private int length;

    Stack(){
       head = null;
       tail = null;
       length = 0;
    }

    /*
        O(1) time complexity
        O(N) space complexity

        This is my implementation of the push functionality for a stack using a linked list.
     */
    public void push(int val){
        Item pushItem = new Item(val);

        if(head == null){
            head = pushItem;
            tail = pushItem;
        }
        else {
            pushItem.next = head;
            head = pushItem;
        }
        length++;
    }

    /*
        O(1) Time and Space Complexity

        This is my implementation of the pop functionality for a stack using a linked list
     */
    public int pop(){
        int res = 0;

        if(length == 0)
            throw new NullPointerException("No values are inside of the stack");

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

        This is my implementation of the peek functionality for a stack
     */
    public int peek(){
        if(length == 0)
            return -1;

        return head.val;
    }
}
