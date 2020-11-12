package com.company;

import java.util.ArrayList;

public class PriorityQueue {
    class Node{
        int val;
        int priorityLevel;

        Node(int val, int priorityLevel){
            this.val = val;
            this.priorityLevel = priorityLevel;
        }
    }

    ArrayList<Node> minQueue;
    ArrayList<Node> maxQueue;

    PriorityQueue(){
        minQueue = new ArrayList<>();
        maxQueue = new ArrayList<>();
    }

    public ArrayList<Node> returnMin(){
        return minQueue;
    }

    public ArrayList<Node> returnMax(){
        return maxQueue;
    }

    public void enqueue(int value, int priority){
        Node data = new Node(value, priority);

        minBubbleUp(data);
        maxBubbleUp(data);
    }

    private void minBubbleUp(Node n){
        int index = minQueue.size();
        minQueue.add(n);

        while(index > 0){
            int parentIndex = (int)Math.floor((index-1)/2);
            Node temp = minQueue.get(parentIndex);

            if(temp.priorityLevel > n.priorityLevel){
                minQueue.set(index, temp);
                minQueue.set(parentIndex, n);
                index = parentIndex;
            }
            else
                break;
        }
    }

    private void maxBubbleUp(Node n){
        int index = maxQueue.size();
        maxQueue.add(n);

        while(index > 0){
            int parentIndex = (int)Math.floor((index-1)/2);
            Node temp = maxQueue.get(parentIndex);

            if(temp.priorityLevel < n.priorityLevel){
                maxQueue.set(index, temp);
                maxQueue.set(parentIndex, n);
                index = parentIndex;
            }
            else
                break;
        }
    }

    public Node minDequeue(){
        Node res;
        if(minQueue.size() > 0) {
            res = minQueue.get(0);
            minQueue.set(0, minQueue.get(minQueue.size() - 1));
            minQueue.set(minQueue.size() - 1, res);
            minQueue.remove(minQueue.size() - 1);
        }
        else
            return null;

        int parent = 0;
        int length = minQueue.size();
        while(parent < minQueue.size()){
            int leftChildIndex = (2 * parent) + 1;
            int rightChildIndex = (2 * parent) + 2;

            Node leftChildVal;
            Node rightChildVal;
            Node parentVal = minQueue.get(parent);

            if(leftChildIndex < length && rightChildIndex < length){
                leftChildVal = minQueue.get(leftChildIndex);
                rightChildVal = minQueue.get(rightChildIndex);

                if(leftChildVal.priorityLevel < parentVal.priorityLevel && rightChildVal.priorityLevel > leftChildVal.priorityLevel){
                    minQueue.set(parent, leftChildVal);
                    minQueue.set(leftChildIndex, parentVal);
                    parent = leftChildIndex;
                }
                else if(rightChildVal.priorityLevel < parentVal.priorityLevel && leftChildVal.priorityLevel > rightChildVal.priorityLevel){
                    minQueue.set(parent, rightChildVal);
                    minQueue.set(rightChildIndex, parentVal);
                    parent = rightChildIndex;
                }
                else
                    break;
            }
            else if(leftChildIndex < length && rightChildIndex >= length){
                leftChildVal = minQueue.get(leftChildIndex);

                if(leftChildVal.priorityLevel < parentVal.priorityLevel) {
                    minQueue.set(parent, leftChildVal);
                    minQueue.set(leftChildIndex, parentVal);
                    parent = leftChildIndex;
                }
                else
                    break;
            }
            else if (leftChildIndex >= length && rightChildIndex < length){
                rightChildVal = minQueue.get(rightChildIndex);

                if(rightChildVal.priorityLevel < parentVal.priorityLevel) {
                    minQueue.set(parent, rightChildVal);
                    minQueue.set(rightChildIndex, parentVal);
                    parent = rightChildIndex;
                }
                else
                    break;
            }
            else
                break;
        }

        return res;
    }

    public Node maxDequeue(){
        Node res;
        if(maxQueue.size() > 0) {
            res = maxQueue.get(0);
            maxQueue.set(0, maxQueue.get(maxQueue.size() - 1));
            maxQueue.set(maxQueue.size() - 1, res);
            maxQueue.remove(maxQueue.size() - 1);
        }
        else
            return null;

        int parent = 0;
        int length = maxQueue.size();
        while(parent < maxQueue.size()){
            int leftChildIndex = (2 * parent) + 1;
            int rightChildIndex = (2 * parent) + 2;

            Node leftChildVal;
            Node rightChildVal;
            Node parentVal = maxQueue.get(parent);

            if(leftChildIndex < length && rightChildIndex < length){
                leftChildVal = maxQueue.get(leftChildIndex);
                rightChildVal = maxQueue.get(rightChildIndex);

                if(leftChildVal.priorityLevel > parentVal.priorityLevel && rightChildVal.priorityLevel < leftChildVal.priorityLevel){
                    maxQueue.set(parent, leftChildVal);
                    maxQueue.set(leftChildIndex, parentVal);
                    parent = leftChildIndex;
                }
                else if(rightChildVal.priorityLevel > parentVal.priorityLevel && leftChildVal.priorityLevel < rightChildVal.priorityLevel){
                    maxQueue.set(parent, rightChildVal);
                    maxQueue.set(rightChildIndex, parentVal);
                    parent = rightChildIndex;
                }
                else
                    break;
            }
            else if(leftChildIndex < length && rightChildIndex >= length){
                leftChildVal = maxQueue.get(leftChildIndex);

                if(leftChildVal.priorityLevel > parentVal.priorityLevel) {
                    maxQueue.set(parent, leftChildVal);
                    maxQueue.set(leftChildIndex, parentVal);
                    parent = leftChildIndex;
                }
                else
                    break;
            }
            else if (leftChildIndex >= length && rightChildIndex < length){
                rightChildVal = maxQueue.get(rightChildIndex);

                if(rightChildVal.priorityLevel > parentVal.priorityLevel) {
                    maxQueue.set(parent, rightChildVal);
                    maxQueue.set(rightChildIndex, parentVal);
                    parent = rightChildIndex;
                }
                else
                    break;
            }
            else
                break;
        }

        return res;
    }
}
