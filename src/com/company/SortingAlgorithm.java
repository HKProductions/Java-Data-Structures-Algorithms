package com.company;

public class SortingAlgorithm {

    /*
        O(N^2) time complexity
        O(1) space complexity
        This is my implementation of bubble sort on a specific type of array using the classic traditional implementation4

        TODO: Make the function more generic to be used for other array types
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

        // return the sorted array
        return nums;
    }

    /*
        O(N^2) time complexity
        O(1) space complexity
        This is my implementation of bubble sort on a specific type of array using a slight optimization to
            check if we already sorted the array completely before reaching end of array

        TODO: Make the function more generic to be used for other array types
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

        // return the sorted array
        return nums;
    }

    /*
        O(N^2) time complexity
        O(1) space complexity
        This is my implementation of the selection sort algorithm using a specific array type to sort it

        TODO: Make the function more generic to be used for other array types
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

        // Return the sorted nums array
        return nums;
    }

    /*
        O(N^2) time complexity
        O(1) space complexity
        This is my implementation of the insertion sort algorithm

        TODO: Make the function more generic to be used for other array types
     */
    public int[] insertionSort(int[] nums){
        /*
            Check to see if nums array is less than or equal to 1
                If so return nums array as it is
         */
        if(nums.length <= 1)
            return nums;

        /*
            Have a for loop that starts from the second element and goes to the end
                Store the value at that index in a temp variable
                Have another for loop that starts from where the previous for loop is at and goes backwards till it gets to the start of the array
                    Check to see if the temp variable is less than the current value for the second for loop index
                        If it is swap the values

         */
        for(int i = 1; i < nums.length; i++){
            for(int j = i; j > 0 && nums[j] < nums[j-1]; j--){
                int currVal = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = currVal;
            }
        }

        //Return the sorted array
        return nums;
    }
}
