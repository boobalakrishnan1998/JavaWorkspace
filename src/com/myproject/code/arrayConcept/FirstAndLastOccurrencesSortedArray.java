package com.myproject.code.arrayConcept;

import java.util.Arrays;

public class FirstAndLastOccurrencesSortedArray {

    public static void main(String[] args) {
        int key = 7;
        Integer[] intArray = new Integer[]{1, 4, 5, 6, 7, 7, 7, 43, 50, 60, 70, 99, 100};
       System.out.println(Arrays.toString(findFirstAndLast(intArray, key, intArray.length)));
    }
    private static int[] findFirstAndLast(Integer[] intArray, int key, int n) {

        int first = findFirst(intArray, key, n);
        if (first == -1) return new int[]{-1, -1};
        int last = findLast(intArray, key, n);
       return new int[]{first, last};
    }

    private static int findFirst(Integer[] arr, int key, int n) {
        int low = 0, high = n - 1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    private static int findLast(Integer[] arr, int key, int n) {
        int low = 0, high = n - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }
}
