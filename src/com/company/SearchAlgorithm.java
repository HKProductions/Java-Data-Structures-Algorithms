package com.company;

public class SearchAlgorithm {

    /*
        O(N) time complexity
        O(1) space complexity
        This is my implementation of the linear search algorithm for searching through an array

        TODO: Make the function more generic to be used for other array types
     */
    public int linearSearch(int[] nums, int target){
        /*
            Check to see if nums array length is less than 1
                If it is return with -1
         */
        if(nums.length < 1)
            return -1;

        /*
            Loop through entire nums array
                Check to see if nums index value is equal to target
                    If it is return index
         */
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target)
                return i;
        }

        // If target value can't be found in array retain with -1
        return -1;
    }

    /*
        O(log N) time complexity
        O(1) space complexity
        This is my implementation of the binary search algorithm to search for a specfic input in a sorted array

        TODO: Make the function more generic to be used for other array types
     */
    public int binarySearch(int[] nums, int target){
        /*
            Check to see if nums array length is less than 1
                If it is return with -1
         */
        if(nums.length < 1)
            return -1;

        // Have three variables to store the max, min, mid of the array
        int min = 0;
        int max = nums.length - 1;
        int mid = (min + max) / 2;

        /*
            Start looping through the array while min is less than max
                Check to see if mid value of array is equal to equal
                    If so return mid
                If mid is more than target
                    Set max to mid - 1
                If mid is less than target
                    Set min to mid + 1
                Calculate new mid
         */
        while(min <= max){
            if(nums[mid] == target)
                return mid;

            if(nums[mid] > target)
                max = mid - 1;
            else
                min = mid + 1;

            mid = (min + max) / 2;
        }

        // return -1 if not found in array
        return -1;
    }

    /*
        O(N + M) time complexity
        O(1) space complexity
        This is my implemenation of a naive string search to see how many occurances of a specific string appear in the second string

        TODO: Make the function more generic to be used for other array types
     */
    public int naiveStringSearch(String s1, String s2){
        /*
            Check to see if either string has a size less than zero
                If so return 0
         */
        if((s1.length() <= 0 && s2.length() > 0) || (s1.length() > 0 && s2.length() <= 0))
            return 0;

        /*
            Check to see if both strings are empty
                If so return 1
         */
        if(s1.length() == 0 && s2.length() == 0)
            return 1;

        /*
            Find out if s1 is longer than s2
                If so swap s1 with s2
         */
        if(s1.length() > s2.length()){
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }

        // Have two variables one with the starting index of s1 and another one to keep count
        int index = 0;
        int count = 0;

        /*
            Loop through each character of string s2
                If character of s2 matches character at index of s1
                    Increase s1 index
                    Check to see if s1 index equals size of s1 length
                        Increase count and reset s1 index to starting point
                Else reset s1 index to 0
         */
        for(char c : s2.toCharArray()){
            if(c == s1.charAt(index)){
                index++;
                if(index == s1.length()){
                    count++;
                    index = 0;
                }
            }
            else
                index = 0;
        }

        // return the count
        return count;
    }
}
