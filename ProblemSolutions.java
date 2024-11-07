/******************************************************************
 *
 *   Taylor Hales / COMP 400C-001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        // create HashSet then add all elements in list1 to it
        HashSet<Integer> set = new HashSet<>();
        for (int num : list1){
            set.add(num);
        }

        // check if all of the elements in list2 is in the Hashset
        for (int num : list2){
            if (!set.contains(num)){
                return false; // if any element is not in Hashset, return false
            }
        }

        return true; // if all elements are found, return true
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // create a min-heap to store k largest element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // add the elements to the min-heap
        for (int num : array){
            minHeap.add(num);

            // if the heap size gets bigger than k, remove the smallest element
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        // the root of the min-heap is the kth largest element
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // create a merged array to hold the elements
        int[] mergeArray = new int[array1.length + array2.length];

        // copy elements from array1 & array2 into the new mergedArray
        System.arraycopy(array1, 0, mergeArray, 0, array1.length);
        System.arraycopy(array2, 0, mergeArray, array1.length, array2.length);

        // sort the merged array
        Arrays.sort(mergeArray);

        return mergeArray;
    }

}