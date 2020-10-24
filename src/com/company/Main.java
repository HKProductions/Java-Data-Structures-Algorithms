package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    /*
	        Common Problem Solving Methods Testing
	            Focus on counting frequency, two pointers, and sliding window
	     */
        testValidAnagram();
        testCountUniqueValues();
        testAveragePair();
        testIsSubsequence();

        // Recursive Functions Testing
        testPowerRec();
        testFactorial();
        testProductOfArrayList();
        testRecursiveRange();
        testFib();

        // Searching Algorithms Testing
        testLinearSearch();
        testBinarySearch();
        testNaiveStringSearch();

        // Sorting Algorithms Testing
        testBubbleSort();
        testSelectionSort();
        testInsertionSort();
        testMergeSort();
        testQuickSort();
        testRadixSort();

        // Data Structure: Linked List Testing
        testSinglyLinkedList();

        // Data Structure: Stack Testing
        testStack();

        // Data Structure: Queue Testing
        testQueue();

        // Data Structure: Binary Search Tree
        testBinarySearchTree();

    }

    private static void testValidAnagram(){
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

    private static void testCountUniqueValues(){
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

    private static void testAveragePair(){
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

    private static void testIsSubsequence(){
        commonProblemSolvingMethods cpsm = new commonProblemSolvingMethods();

        System.out.println("\nIs Subsequence Test: ");
        System.out.println(cpsm.isSubsequence("hello", "hello world"));
        System.out.println(cpsm.isSubsequence("sing", "string"));
        System.out.println(cpsm.isSubsequence("abc", "abracadabra"));
        System.out.println(cpsm.isSubsequence("abc", "acb"));
        System.out.println(cpsm.isSubsequence("", "help"));
        System.out.println(cpsm.isSubsequence("help", ""));
    }

    private static void testPowerRec(){
        recursion rec = new recursion();

        System.out.println("\nExponential power recursion test: ");
        System.out.println(rec.powerRec(2, 0));
        System.out.println(rec.powerRec(2, 2));
        System.out.println(rec.powerRec(2, 4));
    }

    private static void testFactorial(){
        recursion rec = new recursion();

        System.out.println("\nFactorial test: ");
        System.out.println(rec.factorial(1));
        System.out.println(rec.factorial(2));
        System.out.println(rec.factorial(4));
        System.out.println(rec.factorial(7));
    }

    private static void testProductOfArrayList(){
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

    private static void testRecursiveRange(){
        recursion rec = new recursion();

        System.out.println("\nRecursive Range test: ");
        System.out.println(rec.recursiveRange(6));
        System.out.println(rec.recursiveRange(10));
        System.out.println(rec.recursiveRange(0));
        System.out.println(rec.recursiveRange(-1));
    }

    private static void testFib(){
        recursion rec = new recursion();

        System.out.println("\nFibbonanchi test: ");
        System.out.println(rec.fib(4));
        System.out.println(rec.fib(10));
        System.out.println(rec.fib(28));
        System.out.println(rec.fib(35));
    }

    private static void testLinearSearch(){
        SearchAlgorithm sa = new SearchAlgorithm();

        int[] test1 = {10,15,20,25,30};
        int[] test2 = {19,15,9,8,7,6,5,4,3,2,1,0};
        int[] test3 = {100};
        int[] test4 = {1,2,3,4,5,6};
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

    private static void testBinarySearch(){
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

    private static void testNaiveStringSearch(){
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

    private static void testBubbleSort(){
        SortingAlgorithm sa = new SortingAlgorithm();

        int[] test1 = {1,15,2,3,8,30,81,5,10};
        int[] test2 = {-1,15,-5,-16,51,-20,-1};
        int[] test3 = {0};
        int[] test4 = {};
        int[] test5 = {1,2,3,8,30,81,5,10};
        int[] test6 = {-1,15,-5,-16,51,-20,-1};
        int[] test7 = {0};
        int[] test8 = {};

        System.out.print("\nBubble Sort Testing: ");
        printArray(sa.bubbleSortV1(test1));
        printArray(sa.bubbleSortV1(test2));
        printArray(sa.bubbleSortV1(test3));
        printArray(sa.bubbleSortV1(test4));

        System.out.println();

        System.out.print("\nBubble Sort Optimization Testing: ");
        printArray(sa.bubbleSortV1(test5));
        printArray(sa.bubbleSortV1(test6));
        printArray(sa.bubbleSortV1(test7));
        printArray(sa.bubbleSortV1(test8));

        System.out.println();
    }

    private static void testSelectionSort(){
        SortingAlgorithm sa = new SortingAlgorithm();

        int[] test1 = {1,15,2,3,8,30,81,5,10};
        int[] test2 = {-1,15,-5,-51,-16,51,-20,-1};
        int[] test3 = {0};
        int[] test4 = {};
        int[] test5 = {1,2,3,4,5,6,7,8};

        System.out.print("\nSelection Sort Testing: ");
        printArray(sa.selectionSort(test1));
        printArray(sa.selectionSort(test2));
        printArray(sa.selectionSort(test3));
        printArray(sa.selectionSort(test4));
        printArray(sa.selectionSort(test5));

        System.out.println();
    }

    private static void testInsertionSort(){
        SortingAlgorithm sa = new SortingAlgorithm();

        int[] test1 = {1,15,2,3,8,30,81,5,10,58};
        int[] test2 = {-1,15,-51,-16,51,-20,-1};
        int[] test3 = {0};
        int[] test4 = {};
        int[] test5 = {1,2,3,4,5,6,7,8};

        System.out.print("\nInsertion Sort Testing: ");
        printArray(sa.insertionSort(test1));
        printArray(sa.insertionSort(test2));
        printArray(sa.insertionSort(test3));
        printArray(sa.insertionSort(test4));
        printArray(sa.insertionSort(test5));

        System.out.println();
    }

    private static void testMergeSort(){
        SortingAlgorithm sa = new SortingAlgorithm();

        int[] test1 = {1,15,2,3,8,30,81,5,10,58,-91};
        int[] test2 = {-1,15,33,-51,-16,51,-20,-1};
        int[] test3 = {0};
        int[] test4 = {};
        int[] test5 = {1,2,3,4,5,6,7,8};

        test1 = sa.mergeSort(test1);
        test2 = sa.mergeSort(test2);
        test3 = sa.mergeSort(test3);
        test4 = sa.mergeSort(test4);
        test5 = sa.mergeSort(test5);

        System.out.print("\nMerge Sort Testing: ");
        printArray(test1);
        printArray(test2);
        printArray(test3);
        printArray(test4);
        printArray(test5);

        System.out.println();
    }

    private static void testQuickSort(){
        SortingAlgorithm sa = new SortingAlgorithm();

        int[] test1 = {15,2,8,30,81,5,10,58,-91};
        int[] test2 = {-1,15,33,-51,-16,51,-20,-1};
        int[] test3 = {0};
        int[] test4 = {};
        int[] test5 = {1,2,3,4,5,6,7,8};

        System.out.print("\nQuick Sort testing: ");
        printArray(sa.pivotSort(test1, 0, test1.length));
        printArray(sa.pivotSort(test2, 0, test2.length));
        printArray(sa.pivotSort(test3, 0, test3.length));
        printArray(sa.pivotSort(test4, 0, test4.length));
        printArray(sa.pivotSort(test5, 0, test5.length));

        System.out.println();
    }

    private static void testRadixSort(){
        SortingAlgorithm sa = new SortingAlgorithm();

        int[] test1 = {1, 4, 12412, 2, 18, 3023, 124, 123, 81, 9};
        int[] test2 = {100};
        int[] test3 = {};

        System.out.print("\nRadix Sort testing: ");
        printArray(sa.radixSort(test1));
        printArray(sa.radixSort(test2));
        printArray(sa.radixSort(test3));

        System.out.println();
    }

    private static void testSinglyLinkedList(){
        SinglyLinkedList sll = new SinglyLinkedList();

        System.out.println("\nLinked List Testing:");
        /*System.out.println("Testing out remove functionality for empty linked list");
        System.out.println("Removed value: " + sll.remove() + "\n");*/

        System.out.println("Testing out adding in value into empty linked list using an index");
        sll.add(0, 19);
        printLinkedList(sll.returnList());

        System.out.println("Testing out remove function");
        System.out.println("Removed value: " + sll.remove() + "\n");

        System.out.println("Testing out adding in values into populated linked list using regular add function");
        sll.add(15);
        sll.add(21);
        sll.add(1);
        printLinkedList(sll.returnList());

        System.out.println("Testing out remove at index function");
        sll.remove(0);
        printLinkedList(sll.returnList());

        System.out.println("Testing out adding in values into populated linked list using add at index function");
        sll.add(0, 5);
        sll.add(2, 62);
        sll.add(3, 92);
        printLinkedList(sll.returnList());

        /*System.out.println("Testing out adding in values into populated linked list using add at index function where the index is larger than list");
        sll.add(9, 72);*/

        System.out.println("Testing out adding value at the start of the linked list");
        sll.addFirst(200);
        printLinkedList(sll.returnList());

        System.out.println("Testing out adding value at the end of the linked list");
        sll.addLast(1996);
        printLinkedList(sll.returnList());

        System.out.println("Testing out get functionality of the linked list");
        System.out.println(sll.getFirst());
        System.out.println(sll.getLast());
        System.out.println(sll.get(3) + "\n");

        System.out.println("Testing out set functionality of the linked list");
        sll.set(0, 2014);
        sll.set(4, 600);
        sll.set(6, 3);
        printLinkedList(sll.returnList());

        System.out.println("Testing out reverse functionality for a linked list");
        sll.reverse();
        printLinkedList(sll.returnList());

        System.out.println("Testing out remove function");
        sll.remove();
        printLinkedList(sll.returnList());

        System.out.println("Testing out remove at index function");
        sll.remove(3);
        sll.removeLast();
        printLinkedList(sll.returnList());
        sll.removeFirst();
        printLinkedList(sll.returnList());
    }

    private static void testStack(){
        Stack s = new Stack();
        s.push(10);
        s.push(51);
        s.push(71);
        s.push(2013);

        System.out.println("Testing out pop and peek stack functionality");
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        s.push(1241);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());

        /*System.out.println("Testing out error testing of stacks");
        System.out.println(s.peek());
        System.out.println(s.pop());*/
    }

    private static void testQueue(){
        Queue q = new Queue();
        q.push(10);
        q.push(15);
        q.push(500);
        q.push(1000);

        System.out.println("\nTesting out peek and pop functionality of Queues");
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());
        q.push(40000);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());

        /*System.out.println("Testing out error handling of queues");
        System.out.println(q.peek());
        System.out.println(q.pop());*/
    }

    private static void testBinarySearchTree(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(1);
        bst.insert(15);
        bst.insert(0);
        bst.insert(14);
        bst.insert(10);

        System.out.println("\nTesting out insert and find functionality for binary search tree");
        System.out.println(bst.find(10));
        System.out.println(bst.find(11));
        System.out.println(bst.find(15));
        System.out.println(bst.find(60));
        System.out.println(bst.find(1));
    }

    private static void printArray(int[] arr){
        System.out.println();

        if(arr.length <= 0){
            System.out.print("This is an empty array");
            return;
        }

        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    private static void printLinkedList(SinglyLinkedList.Node list){
        while(list != null){
            System.out.println(list.val);
            list = list.next;
        }

        System.out.println();
    }
}
