package com.myproject.code.arrayConcept;

import java.util.*;

public class Find3SumArray {

    public static void main(String[] args) {
        int n = 5, target = 4;
        int[] arr = {1, 2, 5, 6, 7, 1};
        System.out.println(is3SumArray(arr, target));
        System.out.println(find3SumArray(arr, target));
    }

    private static ArrayList<List<Integer>> find3SumArray(int[] arr, int target) {
        ArrayList<List<Integer>> arrList = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int j = i + 1, k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    arrList.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j + 1]) j++;
                    while (j < k && arr[k] == arr[k - 1]) k--;
                }
            }
        }
        return arrList;
    }

    private static boolean is3SumArray(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int j = i + 1, k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
