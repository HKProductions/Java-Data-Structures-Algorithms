package com.company;

public class SortingAlgorithm {

    /*
        O(N^2) time complexity
        O(1) space complexity
        This is my implementation of bubble sort on a specific type of array using the classic traditional implementation4
     */
    public int[] bubbleSortV1(int[] nums){
        /*
            Check to see if nums array length is less than or equal to 1
                If so return nums array
         */
        if(nums.length <= 1)
            return nums;

        /*
            Loop through nums array nums length time with an index
             Each time we loop we loop through the array from the start up till nums length minus loop index
                 If value at index is greater than next value in index
                     swap values
         */
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length-1-i; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        // return nums
        return nums;
    }

    /*
        O(N^2) time complexity
        O(1) space complexity
        This is my implementation of bubble sort on a specific type of array using a slight optimization to
            check if we already sorted the array completely before reaching end of array
     */
    public int[] bubbleSortV2(int[] nums){
        /*
            Check to see if nums array length is less than or equal to 1
                If so return nums array
         */
        if(nums.length <= 1)
            return nums;

        /*
            Loop through nums array nums length time with an index
                Create a boolean to check if we swapped values
                Each time we loop we loop through the array from the start up till nums length minus loop index
                    If value at index is greater than next value in index swap values
                    If we swap values set swap boolean to true else set it to false
                If swap is equal to false return nums array
         */
        for(int i = 0; i < nums.length; i++){
            boolean swapped = true;
            for(int j = 0; j < nums.length-1-i; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true;
                }
                else
                    swapped = false;
            }

            if(!swapped)
                return nums;
        }

        // return nums
        return nums;
    }

    /*
        O(N^2) time complexity
        O(1) space complexity
        This is my implementation of the selection sort algorithm using a specific array type to sort it
     */
    public int[] selectionSort(int[] nums){
        /*
            Check to see if nums array is less than or equal to 1
                If it is return nums array
        */
        if(nums.length <= 1)
            return nums;

        /*
            Loop through nums array with an index
                Create a min variable to keep track to minimum value
                Loop through rest of nums array starting from index + 1 to end of array
                    Check to see if index value in nums array is less than min variable
                        If it is update min with index
                Check to see if min value doesn't equal current index
                    If it doesn't swap the characters
         */
        for(int i = 0; i < nums.length; i++){
            int minIndex = i;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] < nums[minIndex])
                    minIndex = j;
            }

            if(minIndex != i){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }

        // Return nums array
        return nums;
    }
}
