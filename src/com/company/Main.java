package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // Common Problem Solving Methods Testing
        // Focus on counting frequency, two pointers, and sliding window
        testValidAnagram();
        testCountUniqueValues();
        testAveragePair();
        testIsSubsequence();

        // Recursive Function Testing
        testPowerRec();
        testFactorial();
        testProductOfArrayList();
        testRecursiveRange();
        testFib();

        // Searching Algorithm Testing
        testLinearSearch();
        testBinarySearch();
        testNaiveStringSearch();
    }

    public static void testValidAnagram(){
        commonProblemSolvingMethods cpsm = new commonProblemSolvingMethods();

        System.out.println("\nValidate Anagram Test: ");
        System.out.println(cpsm.validAnagram(" ", " "));
        System.out.println(cpsm.validAnagram("aaz", "zza"));
        System.out.println(cpsm.validAnagram("anagram", "nagaram"));
        System.out.println(cpsm.validAnagram("rat", "car"));
        System.out.println(cpsm.validAnagram("awesome", "awesom"));
        System.out.println(cpsm.validAnagram("amanaplanacanalpanama", "acanalmanplanpamana"));
        System.out.println(cpsm.validAnagram("qwerty", "qeywrt"));
        System.out.println(cpsm.validAnagram("texttwisttime", "timetwisttext"));
    }

    public static void testCountUniqueValues(){
        int[] test1 = {1,1,1,1,1,2};
        int[] test2 = {1,2,3,4,4,4,7,7,12,12,13};
        int[] test3 = {};
        int[] test4 = {-2,-1,-1,0,1};
        commonProblemSolvingMethods cpsm = new commonProblemSolvingMethods();

        System.out.println("\nCount Unique Values Test Ver 1: ");
        System.out.println(cpsm.countUniqueValuesVer1(test1));
        System.out.println(cpsm.countUniqueValuesVer1(test2));
        System.out.println(cpsm.countUniqueValuesVer1(test3));
        System.out.println(cpsm.countUniqueValuesVer1(test4));

        System.out.println("\nCount Unique Values Test Ver 2:");
        System.out.println(cpsm.countUniqueValuesVer2(test1));
        System.out.println(cpsm.countUniqueValuesVer2(test2));
        System.out.println(cpsm.countUniqueValuesVer2(test3));
        System.out.println(cpsm.countUniqueValuesVer2(test4));
    }

    public static void testAveragePair(){
        int[] test1 = {1,2,3};
        int[] test2 = {1,3,3,5,6,7,10,12,19};
        int[] test3 = {-1,0,3,4,5,6};
        int[] test4 = {};
        commonProblemSolvingMethods cpsm = new commonProblemSolvingMethods();

        System.out.println("\nAverage Pair Test: ");
        System.out.println(cpsm.averagePair(test1, 2.5));
        System.out.println(cpsm.averagePair(test2, 8));
        System.out.println(cpsm.averagePair(test3, 4.1));
        System.out.println(cpsm.averagePair(test4, 4));
    }

    public static void testIsSubsequence(){
        commonProblemSolvingMethods cpsm = new commonProblemSolvingMethods();

        System.out.println("\nIs Subsequence Test: ");
        System.out.println(cpsm.isSubsequence("hello", "hello world"));
        System.out.println(cpsm.isSubsequence("sing", "string"));
        System.out.println(cpsm.isSubsequence("abc", "abracadabra"));
        System.out.println(cpsm.isSubsequence("abc", "acb"));
        System.out.println(cpsm.isSubsequence("", "help"));
        System.out.println(cpsm.isSubsequence("help", ""));
    }

    public static void testPowerRec(){
        recursion rec = new recursion();

        System.out.println("\nExponential power recursion test: ");
        System.out.println(rec.powerRec(2, 0));
        System.out.println(rec.powerRec(2, 2));
        System.out.println(rec.powerRec(2, 4));
    }

    public static void testFactorial(){
        recursion rec = new recursion();

        System.out.println("\nFactorial test: ");
        System.out.println(rec.factorial(1));
        System.out.println(rec.factorial(2));
        System.out.println(rec.factorial(4));
        System.out.println(rec.factorial(7));
    }

    public static void testProductOfArrayList(){
        recursion rec = new recursion();
        ArrayList<Integer> test1 = new ArrayList<>(List.of(1,2,3));
        ArrayList<Integer> test2 = new ArrayList<>(List.of(1,2,3,10));
        ArrayList<Integer> test3 = new ArrayList<>(List.of(0,1,2,3,10));
        ArrayList<Integer> test4 = new ArrayList<>();


        System.out.println("\nProduct of ArrayList test: ");
        System.out.println(rec.productOfArrayList(test1));
        System.out.println(rec.productOfArrayList(test2));
        System.out.println(rec.productOfArrayList(test3));
        System.out.println(rec.productOfArrayList(test4));
    }

    public static void testRecursiveRange(){
        recursion rec = new recursion();

        System.out.println("\nRecursive Range test: ");
        System.out.println(rec.recursiveRange(6));
        System.out.println(rec.recursiveRange(10));
        System.out.println(rec.recursiveRange(0));
        System.out.println(rec.recursiveRange(-1));
    }

    public static void testFib(){
        recursion rec = new recursion();

        System.out.println("\nFibbonanchi test: ");
        System.out.println(rec.fib(4));
        System.out.println(rec.fib(10));
        System.out.println(rec.fib(28));
        System.out.println(rec.fib(35));
    }

    public static void testLinearSearch(){
        SearchAlgorithm sa = new SearchAlgorithm();

        int[] test1 = {10,15,20,25,30};
        int[] test2 = {9,8,7,6,5,4,3,2,1,0};
        int[] test3 = {100};
        int[] test4 = {1,2,3,4,5};
        int[] test5 = {};

        System.out.println("\nLinear Search test:");
        System.out.println(sa.linearSearch(test1, 15));
        System.out.println(sa.linearSearch(test2, 4));
        System.out.println(sa.linearSearch(test3, 100));
        System.out.println(sa.linearSearch(test4, 6));
        System.out.println(sa.linearSearch(test2, 10));
        System.out.println(sa.linearSearch(test3, 200));
        System.out.println(sa.linearSearch(test5, 15));

    }

    public static void testBinarySearch(){
        SearchAlgorithm sa = new SearchAlgorithm();

        int[] test1 = {10,15,20,25,30};
        int[] test2 = {0,1,2,3,4,5,6,7,8,9};
        int[] test3 = {100};
        int[] test4 = {1,2,3,4,5};
        int[] test5 = {};

        System.out.println("\nBinary Search test:");
        System.out.println(sa.binarySearch(test1, 15));
        System.out.println(sa.binarySearch(test2, 4));
        System.out.println(sa.binarySearch(test3, 100));
        System.out.println(sa.binarySearch(test4, 6));
        System.out.println(sa.binarySearch(test2, 10));
        System.out.println(sa.binarySearch(test3, 200));
        System.out.println(sa.binarySearch(test5, 15));
    }

    public static void testNaiveStringSearch(){
        SearchAlgorithm sa = new SearchAlgorithm();

        System.out.println("\nNaive String Search test: ");
        System.out.println(sa.naiveStringSearch("haha", "hahaiadfe advce hahapadce"));
        System.out.println(sa.naiveStringSearch("h", "h"));
        System.out.println(sa.naiveStringSearch("", "h"));
        System.out.println(sa.naiveStringSearch("h", ""));
        System.out.println(sa.naiveStringSearch("", ""));
        System.out.println(sa.naiveStringSearch("hahaiadfe advce hahapadce", "haha"));
        System.out.println(sa.naiveStringSearch("haiadfe advce hahapadce", "haha"));
    }
}
