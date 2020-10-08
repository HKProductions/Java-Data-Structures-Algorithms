package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /*
        O(NlogN) time complexity
        O(N) space complexity
        This is my implementation of merge sort using recursion to get the array elements down to one and then
            sending the array element to a helper function to merge and sort the values into the appropriate locations

         TODO: Make function more generic
     */
    public int[] mergeSort(int[] nums){
        /*
            Check to see if nums array size is less than or equal to 1
                If so return nums array
         */
        if(nums.length <= 1)
            return nums;

        // Find the midpoint of the array
        int mid = nums.length/2;

        // Use the midpoint of the array to simplify the data on the left and right of the midpoint in order to sort the array
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        // Call a helper function to do sorting and merging of arrays and return the results of that sorted array
        return mergeHelper(left, right);
    }

    /*
        O(N+M) time and space complexity
        This function will create a new array that is the size of both arr1 and arr2 that are passed to it and merge
            them by sorting them from smallest to largest. Do note that both arr1 and arr2 must be sorted already in order
            for this function to work properly

        TODO: Make function more generic
     */
    private int[] mergeHelper(int[] arr1, int[] arr2){
        /*
            Check to see if either arr1 or arr2 are empty
                If one is empty then return the other full array
             Check to see if both arr1 and arr2 are empty
                If so return the one of the arrays
         */
        if(arr1.length <= 0 && arr2.length <= 0)
            return arr1;
        else if(arr1.length <= 0 || arr2.length <= 0){
            if(arr1.length <= 0)
                return arr1;
            else
                return arr2;
        }

        /*
            Declare a new array with the total size being the combined size of arr1 and arr2
            Declare two variables that point the start indexes of arr1 and arr2
            Declare a variables to be the index that points to the start of new array created so values can be inserted
         */
        int[] mergedArr = new int[arr1.length + arr2.length];
        int startArr1 = 0;
        int startArr2 = 0;
        int mergedIndex = 0;

        /*
            Use a while loop to loop through both arrays and to stop once it reaches the end of one of the arrays
                Check to see if arr1 index value is less than arr2 index value
                    If so insert arr1 value into new array at index
                    Increase arr1 index
                Else
                    Insert arr2 value into new array at index
                    Increase arr2 index

                Increase new array index
         */
        while(startArr1 < arr1.length && startArr2 < arr2.length){
            if(arr1[startArr1] < arr2[startArr2]) {
                mergedArr[mergedIndex] = arr1[startArr1];
                startArr1++;
            }
            else {
                mergedArr[mergedIndex] = arr2[startArr2];
                startArr2++;
            }

            mergedIndex++;
        }

        /*
            Check to see if arr1 has reached the end of the array
                Insert each value from arr1 into new array
                Increase arr1 index
                Increase new array index
         */
        while(startArr1 < arr1.length){
            mergedArr[mergedIndex] = arr1[startArr1];
            startArr1++;
            mergedIndex++;
        }

        /*
            Check to see if arr2 has reached the end of the array
                Insert each value from arr2 into new array
                Increase arr2 index
                Increase new array index
         */
        while(startArr2 < arr2.length){
            mergedArr[mergedIndex] = arr2[startArr2];
            startArr2++;
            mergedIndex++;
        }

        // Return the new array
        return mergedArr;
    }

    /*
        *O(NlogN) Time Complexity
        *O(log N) Space Complexity

        This is my implementation of pivot sort where I used the first element of the array to sort the array in place

        * Note that the time and space complexity can change if the array is already sorted
        * O(N^2) Time Complexity
        * O(N) Space Complexity
        * The reason why a sorted array will cause this issue is because when the array is pivoted it sees that the pivot index is already in the proper
            location. So if all the values were in the proper location it would be going through all the values through the recursion call at least once
            and the for loop will be going through the array one more time so it would be going through the array twice. That is why the time complexity
            will be O(N^2). In regards to the O(N) space complexity since we have to go through the entire array from start to end if it's sorted we would
            be making N number of recursion to this function which would take up memory

        TODO: Make this function more generic to allow different array types to interact with function and for wider functionality
     */
    public int[] pivotSort(int[] nums, int start, int end){
        /*
            Iterate through the nums array until left and right overlap each other
                Get the pivot point where the start index value should be placed in the array
                Recursively call the pivotSort function with the array from the start to the one index before the midpoint
                Recursively call the pivotSort function with the array one step after the midpoint to the end
         */
        if(start < end){
            int pivotPoint = pivotHelper(nums, start, end);

            pivotSort(nums, start, pivotPoint-1);
            pivotSort(nums, pivotPoint+1, end);
        }

        // Return nums array once start and end overlap
        return nums;
    }

    /*
        O(N) Time complexity
        O(1) Space complexity
        This function is being used to pivot the array on the first value and sort it according and returning the index at where the first value belongs at

        TODO: Make this function more generic for wider functionality
     */
    private int pivotHelper(int[] arr, int min, int max){
        /*
            Create two variables
                One variable will be used as the pivot variable using the value in the arr at min index
                Second variable will be used to return the index to where the pivot value should reside
         */
        int pivotVal = arr[min];
        int pivIndex = min;

        /*
            Since we don't want to start from the pivot variable we move one step up and go to the end of the array
                We check to see if the value at the specific index in the array is less than the pivot variable
                    If it is increase the pivot index and swap the values at the pivot index with the value at the array index
         */
        for(int i = min+1; i < max; i++){
            if(arr[i] < pivotVal){
                pivIndex++;
                int temp = arr[i];
                arr[i] = arr[pivIndex];
                arr[pivIndex] = temp;
            }
        }

        // Now we finally swap the pivot value with the last minimum index value
        arr[min] = arr[pivIndex];
        arr[pivIndex] = pivotVal;

        // Return the index to where the pivot variable was placed
        return pivIndex;
    }

    /*
        O(K * N) Time Complexity
        O(N + K) Space Complexity

        This is my implementation of radix sort using an int array. This function will only sort properly if all inputs in
            the array are positive

        Note:
            This is in regards to explain more in detail about the time and space complexity. The reason why the time complexity
                is O(K * N) is because K is based on the largest digit in the nums array and we have to loop through the nums array
                K amount of times in order to sort it and the N is based on the fact that we have to loop through the nums array
                N times in order to update each cell in the array.
     */
    public int[] radixSort(int[] nums){
        /*
            Check to see if nums is less than or equal to 1
                If so return nums array
         */
        if(nums.length <= 1)
            return nums;

        // Determine how many digits are in the the largest value in the nums array
        int maxDigitCount = maxDigitsHelper(nums);

        /*
            Loop through the nums array based based on the largest value digit count
                Create a 2D array with 10 empty rows

                Loop through the nums array
                    Check to see what the value is at the current digit value
                    Place value in the correct row in the 2D array

                Have a value to indicate which index to update in the nums array

                Loop through each row of the of the 2D array
                    Loop through each column of the 2D array
                        Insert the value into the nums array
                        Increase index value for nums array

         */
        for(int i = 0; i < maxDigitCount; i++){
            ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();

            for(int j = 0; j < 10; j++){
                ArrayList<Integer> container = new ArrayList<>();
                buckets.add(container);
            }

            for(int val : nums){
                int index = getDigitHelper(val, i);
                buckets.get(index).add(val);
            }

            int numsIndex = 0;
            for(int j = 0; j < buckets.size(); j++){
                for(int val : buckets.get(j)){
                    nums[numsIndex] = val;
                    numsIndex++;
                }
            }
        }

        // Return sorted array
        return nums;
    }

    private int getDigitHelper(int value, int index){
        // Divide the value by 10 by index-1 times
        for(int i = 0; i < index; i++){
            value /= 10;
        }

        // Do a mod to the altered value after the for loop to get the remainder value at the index and return that value
        return value % 10;
    }

    private int getDigitCountHelper(int value){
        /*
            Check to see if value is less than 0
                If so convert the value to a positive number using absolute value
         */
        if(value < 0)
            value = Math.abs(value);

        /*
            Check to see if value is equal to 0
                If so return 1
         */
        if(value == 0)
            return 1;

        // Do a log base 10 to call to determine how many digits are in the value and return count
        return (int)Math.log10(value) + 1;
    }

    private int maxDigitsHelper(int[] nums){
        /*
            Check to see if nums array is less than 1
                If so return 0
         */
        if(nums.length < 1)
            return 0;

        // Have a value set to 0 to keep track of the max number of digits
        int maxDigitCount = 0;

        /*
            Loop through nums array
                Send value at specific index in nums to getDigitCountHelper function
                Check to see if value returned from getDigitCountHelper function is greater than max digits count
                    If so update max digit count value to getDigitCountHelper value
         */
        for(int value : nums){
            int temp = getDigitCountHelper(value);
            if(maxDigitCount < temp)
                maxDigitCount = temp;
        }

        // Return max digit count value
        return maxDigitCount;
    }

}
