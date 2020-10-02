package com.company;

import java.util.ArrayList;

public class recursion {
    // O(N) time & space complexity
    // Simple power calculation using recursion to find the total
    public int powerRec(int base, int exp){
        // Check to see if exponent value is 0
            // If it is return 1
        if(exp == 0)
            return 1;

        // Call powerRec again but decrease the exponent value until it hits base case and multiple function result with base
        return base * powerRec(base, exp - 1);
    }

    public int factorial(int val){
        // Check to see if val is equal 1
            // If it is return 1
        if(val <= 1)
            return val;

        // Call factorial again but decrease value until it hits base case and multiple return results with current value
        return val * factorial(val-1);
    }

    // O(N) time and space complexity
    // We will use an arraylist and recursion to calculate the overall product of an arrayList
    public int productOfArrayList(ArrayList<Integer> nums){
        // Check to see if arraylist size less than 1
            // If so return 0
        // Also check if arraylist size is equal to 1
            // If so return single value
        if(nums.size() < 1)
            return 0;
        else if (nums.size() == 1)
            return nums.get(0);

        // Get the value of the last index and store in local variable
        int temp = nums.get(nums.size()-1);

        // Reduce the size of the arraylist by removing last variable
        // This will only take O(1) time since we are removing from the end of the arrayList
        nums.remove(nums.size()-1);

        // Multiple local temp value with returned value from productOfArray and return result
        return temp * productOfArrayList(nums);
    }

    // O(N) time and space complexity
    // This function will recurively find the sum of all integers between 0 and a possible max value
    public int recursiveRange(int max){
        // Check to see if max less than 0
            // if so return 0
        if(max < 0)
            return 0;

        // Check to see if max is less than or equal to 1
            // Return max value
        if(max <= 1)
            return max;

        // Add current max and decrement max and call recursiveRange function again until it hits a base case and then return final result
        return max + recursiveRange(max-1);
    }


    public int fib(int num){
        // Check to see if num is less than or equal to 2
            // If so return 1
        if(num <= 2)
            return 1;

        // Call fib once by decreasing num by 1 and anther call to fib by decreasing by 2 and then add the returning sum and return final result
        return fib(num-1) + fib(num-2);
    }
}
