package com.company;

import java.util.ArrayList;

public class BinaryHeap {
    ArrayList<Integer> minMemory;
    ArrayList<Integer> maxMemory;

    BinaryHeap(){
        minMemory = new ArrayList();
        maxMemory = new ArrayList();
    }

    public ArrayList<Integer> returnMin(){
        return minMemory;
    }

    public ArrayList<Integer> returnMax(){
        return maxMemory;
    }

    public void insert(int val){
        minBubbleUp(val);
        maxBubbleUp(val);
    }

    private void minBubbleUp(int val){
        int index = minMemory.size();
        minMemory.add(val);

        while(index > 0){
            int parentIndex = (int) Math.floor((index - 1) / 2);
            int temp = minMemory.get(parentIndex);

            if(temp > val) {
                minMemory.set(index, temp);
                minMemory.set(parentIndex, val);
                index = parentIndex;
            }
            else
                break;
        }
    }

    private void maxBubbleUp(int val){
        int index = maxMemory.size();
        maxMemory.add(val);

        while(index > 0){
            int parentIndex = (int) Math.floor((index - 1) / 2);
            int temp = maxMemory.get(parentIndex);

            if(temp < val) {
                maxMemory.set(index, temp);
                maxMemory.set(parentIndex, val);
                index = parentIndex;
            }
            else
                break;
        }
    }

    public int extractMin(){
        int res;
        if(minMemory.size() > 0) {
            res = minMemory.get(0);
            minMemory.set(0, minMemory.get(minMemory.size() - 1));
            minMemory.set(minMemory.size() - 1, res);
            minMemory.remove(minMemory.size() - 1);
        }
        else
            return 0;

        int length = minMemory.size();

        int parent = 0;
        while(parent < length){
            int leftChildIndex = (2 * parent) + 1;
            int rightChildIndex = (2 * parent) + 2;

            int leftChildVal;
            int rightChildVal;
            int parentVal = minMemory.get(parent);

            if(leftChildIndex < length  && rightChildIndex < length) {
                leftChildVal = minMemory.get(leftChildIndex);
                rightChildVal = minMemory.get(rightChildIndex);

                if (leftChildVal < parentVal && rightChildVal > leftChildVal) {
                    minMemory.set(parent, leftChildVal);
                    minMemory.set(leftChildIndex, parentVal);
                    parent = leftChildIndex;
                }
                else if(rightChildVal < parentVal && leftChildVal > rightChildVal){
                    minMemory.set(parent, rightChildVal);
                    minMemory.set(rightChildIndex, parentVal);
                    parent = rightChildIndex;
                }
                else
                    break;
            }
            else if(leftChildIndex < length && rightChildIndex >= length){
                leftChildVal = minMemory.get(leftChildIndex);

                if (leftChildVal < parentVal) {
                    minMemory.set(parent, leftChildVal);
                    minMemory.set(leftChildIndex, parentVal);
                    parent = leftChildIndex;
                }
                else
                    break;
            }
            else if(leftChildIndex >= length && rightChildIndex < length){
                rightChildVal = minMemory.get(rightChildIndex);

                if (rightChildVal < parentVal) {
                    minMemory.set(parent, rightChildVal);
                    minMemory.set(rightChildIndex, parentVal);
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

    public int extractMax(){
        int res;

        if(maxMemory.size() > 0) {
            res = maxMemory.get(0);
            maxMemory.set(0, maxMemory.get(maxMemory.size() - 1));
            maxMemory.set(maxMemory.size() - 1, res);
            maxMemory.remove(maxMemory.size() - 1);
        }
        else
            return 0;

        int length = maxMemory.size();

        int parent = 0;
        while(parent < length){
            int leftChildIndex = (2 * parent) + 1;
            int rightChildIndex = (2 * parent) + 2;

            int leftChildVal;
            int rightChildVal;
            int parentVal = maxMemory.get(parent);

            if(leftChildIndex < length  && rightChildIndex < length) {
                leftChildVal = maxMemory.get(leftChildIndex);
                rightChildVal = maxMemory.get(rightChildIndex);

                if (leftChildVal > parentVal && rightChildVal < leftChildVal) {
                    maxMemory.set(parent, leftChildVal);
                    maxMemory.set(leftChildIndex, parentVal);
                    parent = leftChildIndex;
                }
                else if(rightChildVal > parentVal && leftChildIndex < rightChildIndex){
                    maxMemory.set(parent, rightChildVal);
                    maxMemory.set(rightChildIndex, parentVal);
                    parent = rightChildIndex;
                }
                else
                    break;
            }
            else if(leftChildIndex < length && rightChildIndex >= length){
                leftChildVal = maxMemory.get(leftChildIndex);

                if (leftChildVal > parentVal) {
                    maxMemory.set(parent, leftChildVal);
                    maxMemory.set(leftChildIndex, parentVal);
                    parent = leftChildIndex;
                }
                else
                    break;
            }
            else if(leftChildIndex >= length && rightChildIndex < length){
                rightChildVal = maxMemory.get(rightChildIndex);

                if (rightChildVal > parentVal) {
                    maxMemory.set(parent, rightChildVal);
                    maxMemory.set(rightChildIndex, parentVal);
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
