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

        /*
            Create a temp node that points to the head of the current linked list in order for us to traverse the linked list
            Create a prev node that points to null
            Create a variable to count the number of indexes passed starting from 0
         */
        Node temp = head;
        Node prev = null;
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
                newNode.next = temp;
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

    /*
        O(N) time complexity
        O(1) space complexity

        This is my implementation of removing a value anywhere in the linked list

        This function takes O(N) time to complete because if we have to remove the last element in the linked list it
            will have to traverse through the entire linked list till it gets to the end of the list and from there it removes
            the reference to the current node from the previous node. The reason this take O(1) space is because we aren't
            creating any new object but manipulating the existing nodes in the linked list.
     */
    public int remove(int index){
        /*
            Check to see if index is equal to zero
                Call and return result from remove function
         */
        if(index == 0)
            return remove();

        /*
            Check to see if index is less than 0 or greater than the length of linked list minus 1
                If so throw an error for index not existing in linked list
         */
        if(index < 0 || index > length - 1)
            throw new NullPointerException("Index is not part of linked list");

        // Have a temp value that uses the head node to traverse the linked list
        Node temp = head;

        // Have a prev value that points to the prev node but is current set to null
        Node prev = null;

        /*
            Have a count variable to count number of indexes passed
            Have a value to store the value to be returned
         */
        int iCount = 0;
        int resValue = 0;

        /*
            Loop through the linked list until temp value is equal to null
                Check to see if index count is equal to index value
                    Have return value store the current value in the temp val field
                    Have prev node next value point to the temp.next value
                    Decrease the length value
                    Check to see if index is equal to length - 1
                        If so point tail to prev
                    Break out of while loop
                Have the prev node point to current temp value
                Have temp point to the next value in the linked list
                Increase the index count
         */
        while(temp != null){
            if(iCount == index){
                resValue = temp.val;
                prev.next = temp.next;

                if(index == length-1)
                    tail = prev;
                length--;
                break;
            }

            prev = temp;
            temp = temp.next;
            iCount++;
        }

        // Return the return value
        return resValue;
    }

    /*
        O(N) time complexity
        O(1) space complexity

        This is my implementation of removing the last value from the linked list by utilizing one of the remove functions
            created above
     */
    public int pop(){
        return remove(length-1);
    }

    /*
        O(1) time complexity
        O(1) Space complexity

        This is my implementation of removing the first value from the linked list by utilizing one of our remove functions
            created above
     */
    public int removeFirst(){
        return remove();
    }

    /*
        O(N) time complexity
        O(1) space complexity

        This is my implementation of removing the last value from the linked list by utilizing one of the remove functions
            created above
     */
    public int removeLast(){
        return pop();
    }

    /*
        O(N) time complexity
        O(1) space complexity

        This is my implementation of the get method for linked list

        The reason why this function's time complexity is O(N) is because if we have to go to the middle of the linked list
            we have to traverse through the list N number of times until we get to the middle of the list. If we just had to see
            what the value was at the beginning or end of the link list the time complexity would be O(1). The reason why the
            space complexity is O(1) is because we aren't manipulating the linked list or creating any new objects that would
            take up memory. Due to that reason our memory is constant.
     */
    public int get(int index){
        /*
            Check to see if index is equal to 0
                If so return the head node value
         */
        if(index == 0)
            return head.val;

        /*
            Check to see if index is equal to length of linked list minus 1
                If so return the tail node value
         */
        if(index == length-1)
            return tail.val;

        /*
            Check to see if index is valid by checked to see if index is greater than 0 and less than or equal to length of linked list minus 1
                If not throw a null pointer error
         */
        if(index < 0 || index > length-1)
            throw new NullPointerException("Index does not exist in linked list");

        /*
            Create a temp node value to store the head node to be used for traversal
            Create a index count value set to 0
         */
        Node temp = head;
        int iCount = 0;

        /*
            Do a while loop to traverse through the linked list until the next node is null
                Check to index count is equal to index
                    If so return the value at the index using the temp
                Set temp node to the next node in temp
                Increase index count
         */
        while(temp != null){
            if(iCount == index)
                return temp.val;
            temp = temp.next;
            iCount++;
        }

        // Default case return 0
        return 0;
    }

    /*
        O(1) time complexity
        O(1) space complexity

        This is my implementation of the get first function in a linked list. This is utilizing the get function by getting the
            first element in the linked list. Since we are getting the first element it makes the time complexity O(1) since
            we have a direct reference to that node at all times with the head node.
     */
    public int getFirst(){
        return get(0);
    }

    /*
        O(1) time complexity
        O(1) space complexity

        This is my implementation of the get last function in a linked list. This is utilizing the get function by getting the
            last element in the linked list. Since we are getting the last element it makes the time complexity O(1) since
            we have a direct reference to that node at all times with the tail node.
     */
    public int getLast(){
        return get(length-1);
    }

    /*
        O(N) time complexity
        O(1) space complexity

        This is my implementation of the set function for a linked list.

        The reason why this function's time complexity is O(N) is if the user wanted to update the index at length minus 2
            the program would have to traverse through the entire linked list N number of times. If we only had to update the first
            and last value of the linked list it would take O(1) time in that situation because we have a direct reference to those
            two nodes. The reasoning behind why the space complexity is O(1) is because we aren't adding a new node to the linked list
            or creating any new objects that would take up extra memory. Due to that we have constant space
     */
    public void set(int index, int val){
        /*
            Check to see if the index is equal to 0
                If it is set the head node value to the new value
                Exit out of the function
         */
        if(index == 0){
            this.head.val = val;
            return;
        }

        /*
            Check to see if the index is equal to the length of the linked list minus 1
                If it is set the tail node value to the new value
                Exit out of the function
         */
        if(index == length-1){
            this.tail.val = val;
            return;
        }

        /*
            Check if the index is greater than or equal to 0 but less than or equal to the length of linked list minus 1
                If it is not throw a null pointer exception error
         */
        if(index < 0 || index > length-1)
            throw new NullPointerException("Index is out of scope for the linked list");

        /*
            Create a temp node that refers to the head node to traverse through the linked list
            Create a variable to keep count of indexes pass and initialize it to 0
         */
        Node temp = head;
        int iCount = 0;

        /*
            Loop through the linked list with a while loop checking to see if the temp node is not equal to null
                If the index count is equal to the index being searched for
                    Update the temp value node with the new value
                    Exit out of the loop with a break;
                Set temp node to the next temp node
                Increase the index count
         */
        while(temp != null){
            if(iCount == index){
                temp.val = val;
                break;
            }
            temp = temp.next;
            iCount++;
        }
    }

    /*
        O(N) time complexity
        O(1) space complexity

        This is my implementation of reversing a linked list

        The reason why this function's time complexity is O(N) is because we have to traverse through the entire linked list
            reversing the node next pointers. The reason why the space complexity is O(1) is because we aren't adding any new objects
            or adding any new values to the linked list or using up memory. Due to that reason we are just using the current
            nodes already created to reverse it in constant space time.
     */
    public void reverse(){
        // This will have to utilize two pointer one for next and one for curr
        Node curr = head;
        Node next = curr.next;

        // Set the curr val to null and set the tail to the curr node
        curr.next = null;
        tail = curr;

        /*
            Loop through the rest of the linked list with a while loop checking to see if next node is null
                Create a temp node that points to the current next node
                Change next node to curr node
                Change curr node to curr next node
                Check to see if temp node is null
                    If so set the head node to the next node
                Change next node to temp node
         */
        while(next != null){
            Node temp = next.next;
            next.next = curr;
            curr = next;
            if(temp == null)
                head = next;
            next = temp;
        }
    }
}