package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class commonProblemSolvingMethods {

    /*
        O(N) time and space complexity
        This function can be used to check to see if two strings are anagrams of each other or not
     */
    public boolean validAnagram(String a, String b){
        /*

            Check to see if string lengths match up
                If not return false
         */
        if(a.length() != b.length())
            return false;

        // Create some object to store the characters from one string
        HashMap<Character, Integer> mem = new HashMap<>();

        /*
            Loop through one string by turning it into a char array
                Check to see if the character is already in the storage object
                    If it is not in the object add character to object and have it set to 1
                    Else get the character count from the object and increase it's size
         */
        for(char temp : a.toCharArray()){
            if(!mem.containsKey(temp))
                mem.put(temp, 1);
            else
                mem.put(temp, mem.get(temp) + 1);
        }

        /*
            Loop through second string by turning it into a char array
                Check to see if the character is in the storage object
                    If it not in the object return false
                 Else check to see if the character count is greater than 0
                    If it is decrease count by 1
                    Else return false
         */
        for(char temp : b.toCharArray()){
            if(!mem.containsKey(temp))
                return false;
            else{
                if(mem.get(temp) > 0){
                    mem.put(temp, mem.get(temp) - 1);
                }
                else
                    return false;
            }
        }

        //Return true if everything matches up
        return true;
    }

    /*
        O(N) time and space complexity
        This is one version to determine how many unique values are in the array using a HashSet
     */
    public int countUniqueValuesVer1(int[] input){
        /*
            Check to see if input size is greater 1
                If not return input size
         */
        if(input.length <= 1)
            return input.length;

        // Have an object to store all unique input
        HashSet<Integer> uniqueValues = new HashSet<>();

        // Loop through input array and place integars into object
        for(int i : input){
            uniqueValues.add(i);
        }

        // Get the count of integers in object
        return uniqueValues.size();
    }

    /*
        O(N) time complexity
        O(1) space complexity
        This is another version to determine how many unique values are in an integer array using two pointers
     */
    public int countUniqueValuesVer2(int[] input){
        /*
            Check to see if input size is greater 1
                If not return input size
         */
        if(input.length <= 1)
            return input.length;

        // Have a variable to keep track of count starting at 1
        int count = 1;

        // Create two pointers starting at start of array and next value
        int slow = 0;
        int fast = 1;

        /*
            Loop through array until fast pointer reaches end of array
                If slow pointer doesn't equal fast pointer
                    Increase count variable by 1
                    Move slow pointer to fast pointer location
                Increase fast pointer by 1
         */
        while(fast < input.length){
            if(input[slow] != input[fast]){
                count++;
                slow = fast;
            }
            fast++;
        }

        // Return count
        return count;
    }

    /*
        O(N) time complexity
        O(1) space complexity
        This function will parse through an integer array and try to determine if there is a pair of number in the array equal to the target
        This will utilize a two pointer technique
     */
    public boolean averagePair(int[] nums, double target){
        /*
            Check to see if nums array length greater than 1
                If array length is 0 or if array length is 1 and not equal target return false
                Else return true
         */
        if(nums.length <= 1){
            if(nums.length < 1 || (nums.length == 1 && nums[0] != target))
                return false;
            return true;
        }

        // Create two pointers one that starts at beginning of array and one at end of array
        int start = 0;
        int end = nums.length-1;

        /*
            Loop through array by moving the pointers and ensure that start pointer doesn't meet or crossover end pointer
                If sum of nums start value and nums end value divided to 2 equals target
                    Return true
                Check to see if average is greater than target
                    Decrease the end pointer
                Else we have to increase the start pointer
         */
        while(start < end){
            double avg = (double)(nums[start] + nums[end])/2;
            if(avg == target)
                return true;

            if(avg > target)
                end--;
            else
                start++;
        }

        // If pair could not be found return false
        return false;
    }

    /*
        O(N + M) time complexity
        O(1) space complexity
        This function utilities a two pointer approach to parse through first string and see if all characters are in second string
     */
    public boolean isSubsequence(String s1, String s2){
        /*
            Check to see if either of the two strings are empty
                If so than return false
         */
        if(s1.length() <= 0 || s2.length() <= 0)
            return false;

        // Create pointers that parse through s1
        int s1Itr = 0;

        /*
            Start looping through s2
                If pointer value of s1 matches s2 character
                    Increase s1 pointer
                If pointer size is equal to length of s1
                    return true
         */
        for(char sTemp : s2.toCharArray()){
            if(sTemp == s1.charAt(s1Itr))
                s1Itr++;

            if(s1Itr == s1.length())
                return true;
        }

        // If not all values from s1 are found in s2 return false
        return false;
    }
}
