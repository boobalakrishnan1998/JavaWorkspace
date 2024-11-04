package com.myproject.code.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 9, 3, 1, 4, 7, 8};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        mergeArr(arr, low, mid, high);
    }

    private static void mergeArr(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low, right = mid + 1, k = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }
        while (left <= mid) {
            temp.add(arr[left++]);
        }
        while (right <= high) {
            temp.add(arr[right++]);
        }
        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
        int[] right = mergeSort(Arrays.copyOfRange(arr, (arr.length / 2), arr.length));
        return mergeArr(left, right);
    }

    private static int[] mergeArr(int[] left, int[] right) {
        int[] sortedArr = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                sortedArr[k++] = left[i++];
            } else {
                sortedArr[k++] = right[j++];
            }
        }
        if (i < left.length) {
            while (i < left.length) {
                sortedArr[k++] = left[i++];
            }
        }
        if (j < right.length) {
            while (j < right.length) {
                sortedArr[k++] = right[j++];
            }
        }
        return sortedArr;
    }
}
