package com.company;

public class SearchAlgorithm {

    // O(N) time complexity
    // O(1) space complexity
    // This is my implementation of the linear search algorithm for searching through an array
    public int linearSearch(int[] nums, int target){
        // Check to see if nums array length is less than 1
            // If it is return with -1
        if(nums.length < 1)
            return -1;

        // Loop through entire nums array
            // Check to see if nums index value is equal to target
                // If it is return index
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target)
                return i;
        }

        // If target value can't be found in array retain with -1
        return -1;
    }
}
