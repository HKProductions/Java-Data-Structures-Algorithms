package com.company;

public class BinarySearchTree {
    class Node{
        int val;
        Node left;
        Node right;

        Node(){
            left = null;
            right = null;
        }

        Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    private Node root;

    BinarySearchTree(){
        root = null;
    }

    public Node getRoot(){
        return root;
    }

    /*
        O(Log N) time complexity
        O(N) space complexity

        This is my implementation of inserting values into a custom binary search tree. The reason why the time complexity is
            log N is because of the insertHelper function. Do refer to that for the full reasoning.
     */
    public void insert(int value){
        Node newNode = new Node(value);

        if(root == null) {
            root = newNode;
        }
        else {
            Node tempNode = root;
            insertHelper(tempNode, newNode);
        }
    }

    /*
        O(Log N) time complexity
        O(N) space complexity

        This is a recursive helper function for my insert function implementation. The reason the time complexity is
            log N is because if the tree is balanced and accurately sorted it would allow on average to insert the value
            in log N time but this is not always true. The reason for this is if for example all the values were incrementing
            the tree would be heavily right branching and because of that it would make the function run in O(N) time. The reason
            the space time in N because we would have to make N number of calls to the helper function.
     */
    private void insertHelper(Node temp, Node newNode){
        if(temp.val == newNode.val)
            return;

        if(temp.val > newNode.val){
            if(temp.left != null)
                insertHelper(temp.left, newNode);
            else
                temp.left = newNode;
        }
        else{
            if(temp.right != null)
                insertHelper(temp.right, newNode);
            else
                temp.right = newNode;
        }
    }

    /*
        O(Log N) time complexity
        O(N) space complexity

        This is my implementation of finding values in a custom binary search tree. The reason why the time complexity is
            log N is because of the findHelper function. Do refer to that for the full reasoning.
     */
    public boolean find(int value){
        if(root == null)
            return false;

        Node tempNode = root;
        return findHelper(tempNode, value);
    }

    /*
        O(Log N) time complexity
        O(N) space complexity

        This is a recursive helper function for my find function implementation. The reason the time complexity is
            log N is because if the tree is balanced and accurately sorted it would allow on average to find the value
            in log N time but this is not always true. The reason for this is if for example all the values were incrementing
            the tree would be heavily right branching and because of that it would make the function run in O(N) time. The reason
            the space time in N because we would have to make N number of calls to the helper function.
     */
    private boolean findHelper(Node tempNode, int value){
        if(tempNode == null)
            return false;

        if(tempNode.val == value)
            return true;

        if(tempNode.val > value)
            return findHelper(tempNode.left, value);
        else
            return findHelper(tempNode.right, value);
    }
}
