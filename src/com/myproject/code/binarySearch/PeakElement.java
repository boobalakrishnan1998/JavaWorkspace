package com.myproject.code.binarySearch;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 4, 3, 2};
        int index = findPeakElementIndex(arr, arr.length);
        System.out.println(index);
    }

    private static int findPeakElementIndex(int[] arr, int n) {
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                return mid;
            }
            if (arr[mid-1] < arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
