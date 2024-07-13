package com.myproject.code.arrayConcept;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {12, 13, 15, 20, 3, 5, 7, 9, 10,};
        int ans = findElement(arr, 100);
        System.out.println(ans);
        //SearchRotatedSortedArrayWithDuplicates
        int[] arr1 = {3,3,1,2,3,3,3,3,3,3,3};
        boolean isPresent = findElementWitDuplicates(arr1, 4);
        System.out.println(isPresent);
    }

    private static int findElement(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k)
                return mid;
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= k && k <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private static boolean findElementWitDuplicates(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k)
                return true;
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= k && k <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
