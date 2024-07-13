package com.myproject.code.arrayConcept;

public class NumberOfRotationInSortedArray {
    public static void main(String[] args) {
        int[] arr = {12, 13, 15, 20, 0, 3, 5, 7, 9, 10,};
        int ans = findMinElement(arr);
        System.out.println(ans);
        //SearchRotatedSortedArrayWithDuplicates
        int[] arr1 = {3, 3, 0, 1, 2, 3, 3, 3, 3, 3, 3, 3};
        int ans1 = findMinElementWitDuplicates(arr1);
        System.out.println(ans1);
    }

    private static int findMinElement(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }
            if (arr[low] <= arr[mid]) {
                if (ans > arr[low]) {
                    ans = arr[low];
                    index = low;
                }
                low = mid + 1;
            } else {
                if (ans > arr[mid]) {
                    ans = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }

    private static int findMinElementWitDuplicates(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index=-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            if (arr[low] <= arr[mid]) {
                if (ans > arr[low]) {
                    ans = arr[low];
                    index = low;
                }
                low = mid + 1;
            } else {
                if (ans > arr[mid]) {
                    ans = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
