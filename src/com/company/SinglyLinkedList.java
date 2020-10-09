package com.company;

public class SinglyLinkedList {
    /*
        We need a class in order to store a value and point to the next
            Node in a linked list

        We need to account to for when the value sent to this is:
            - Empty
            - Has a value
            - Has a value and pointer to another node
     */
    class Node{
        int val;
        Node next;

        Node(){
            this.next = null;
        }

        Node(int val){
            this.val = val;
            this.next = null;
        }

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    /*
        We need a couple different constructor in order to account for different single linked list
            creation

        Types of creation
            - Empty
     */
    SinglyLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public Node returnList(){
        return head;
    }

    /*
        O(1) Time Complexity
        O(N) Space Complexity

        This is my implementation of adding values into a linked list as long as the user doesn't mind having it placed
            at the end of the linked list

        Reason why the time complexity is O(1) is because we are inserting the value at the end of the linked list.
            Since we keep a reference of the end of the linked list or tail we can refer to that value and have the next
            node point to our new node that we create. Due to the fact that we have to create a new Node to store the value
            that is going to be inserted into the linked list it is going to take up space in our memory so due to that
            space complexity is O(N)
     */
    public void add(int value){
        // Need to create a new node that will be inserted into our linked list
        Node newNode = new Node(value);

        /*
            Check to see if the size of the linked list is empty
                If it is empty point the head and tail to the new node we created
                If it is not empty
                    Get the tail node and have the next value in the node point to the new node
                    Have the tail point to the new node that was inserted
         */
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = tail.next;
        }

        // Finally increase the size of the linked list
        length++;
    }

    /*
        O(N) Time Complexity
        O(N) Space Complexity

        This is an implementation of adding at a specific index in the linked list by parsing through the linked list

        The reason by both the time and space complexity of the linked list is O(N) is because in the worse case situation
            where the index is the length of the linked list minus 2 it has to parse through all the nodes until it gets
            to the length and since we have to create a new node in order to add it to that index our space and time complexity
            end up being O(N)
    */
    public void add(int index, int value){
        /*
            Check to see if index is equal to 0
                Call addFirst function and pass value to it
                Exit out of function with return
         */
        if(index == 0){
            addFirst(value);
            return;
        }

        /*
            Check to see if index is greater than the current length of the linked list minus 1 or is less than 0
                If it is throw an exception of index out of bound
         */
        if(index < 0 || index > length-1)
            throw new NullPointerException("Index: " + index + " is out of bounds of linked list");

        /*
            Check to see if index is equal to length of linked list minus 1
                call addLast function and pass value to it
                Exit out of function with return
         */
        if(index == length - 1){
            addLast(value);
            return;
        }

        // Create a new node in order for the linked list to point the value being inserted
        Node newNode = new Node();
        newNode.val = value;

        // Create a temp node that points to the head of the current linked list in order for us to traverse the linked list
        Node temp = head;

        // Create a prev node that points to null
        Node prev = null;

        // Create a variable to count the number of indexes passed starting from 0
        int iCount = 0;

        /*
            Have a while loop that iterates through the temp node's linked list as long as temp doesn't equal null
                If the variable to count number of indexes is equal to the add index
                    Have the new node's next value point to the next node value in the prev node
                    Have the prev node's next value point to the new node
                    Increase the length variable by one
                    Break out of loop
                Have temp equal to the next node in the temp node
                Increase the number of indexes passed by one
        */
        while(temp != null){
            if(iCount == index){
                newNode.next = prev.next;
                prev.next = newNode;
                length++;
                break;
            }
            prev = temp;
            temp = temp.next;
            iCount++;
        }
    }

    /*
        O(1) Time Complexity
        O(N) Space Complexity

        This is my implementation fof the addFirst function for linked list. This function will insert a value at the
            very beginning of the linked list and make itself the head of the linked list

        The reason why this function runs at O(1) time is because we already know where the head of the linked list is
            and since we know that info we can use it to create a new Node and have it point to the current head node and
            then alter the head node to the point to the new node created. Because we have to create a new Node to store the
            value being added it takes up O(N) amount of space in the memory.
    */
    public void addFirst(int value){
        // Create a new node in order for the linked list to point the value being inserted
        Node newNode = new Node();
        newNode.val = value;

        /*
            Have the new node point it's next node to the head
            Then have head point to the new node inserted

            Check to see if current length is 0
                If it is point the tail to the new node inserted

            Increase the length value
        */
        newNode.next = head;
        head = newNode;

        if(length == 0)
            tail = newNode;

        length++;
    }

    /*
        O(1) Time Complexity
        O(N) Space Complexity

        This is my implementation of the addLast function for linked lists. This function will insert a value at the end of
            the list or the tail and have the value make itself the new tail of the list

        The reason this function runs in O(1) time is because we know what the current tail node is and if we point the tail
            node's next node to the new node being created it would constant time because we aren't having to parse through
            the entire linked list to know where it ends. Due to the fact that we have to create a new Node it take up space in
            out memory of O(N).
     */
    public void addLast(int value){
        // Create a new node in order for the linked list to point the value being inserted
        Node newNode = new Node();
        newNode.val = value;

        /*
            If so get the tail node and have it's next node point to the new node created
            Then have the tail node go to the next node
            Increase the length value
         */
        tail.next = newNode;
        tail = tail.next;
        length++;
    }

    /*
        O(1) Time Complexity
        O(1) Space Complexity

        This is my implementation of removing the value at the head of the linked list

        This function takes O(1) time and space complexity because we aren't looping through the linked list to remove a value
            instead since we already have a pointer to the head of the linked list we are disconnecting the head from it's current
            node to the next node if there is one or null. Since we aren't creating anything new we aren't adding anything extra to
            the memory.
     */
    public int remove(){
        /*
            Check to see if length is greater than 1
                If not throw an error to state it is not possible
         */
        if(this.length < 1)
            throw new NullPointerException("Linked List is empty cannot remove anymore elments");

        // Declare an int variable that will be used to store the value of the head node
        int hValue = head.val;

        /*
            Check to see if head is equal to tail
                Set head and tail to null
             Else
                Set head to head.next
         */
        if(this.head == this.tail){
            head = null;
            tail = null;
        }
        else
            head = head.next;

        /*
            Decrease the length variable
            return result of the head value
         */
        length--;
        return hValue;
    }

    public void remove(int index){
        /*
            Check to see if index is equal to zero
                Call and return result from remove function
         */

        /*
            Check to see if index is less than 0 or greater than the length of linked list minus 1
                If so throw an error for index not existing in linked list
         */

        //
    }
}
