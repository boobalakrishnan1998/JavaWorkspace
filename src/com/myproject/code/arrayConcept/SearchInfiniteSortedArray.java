package com.myproject.code.arrayConcept;

public class SearchInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int ans = findIndex(arr, 130);
        System.out.println(ans);

    }

    private static int findIndex(int[] arr, int key) {
        int low = 0, high = 1;
        while (arr[high] < key) {
            low = high;
            high = 2 * high;
        }
        return binarySearch(arr, low, high, key);
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
