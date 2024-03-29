package com.myproject.code.arrayConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find4SumArray {

    public static void main(String[] args) {
        int n = 5, target = 4;
        int[] arr = {1, 1, 1, 5, 6, 7, 1};
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
            for (int j = i + 1; j < arr.length; j++) {
                if ( j != (i+1) && arr[j] == arr[j - 1]) {
                    continue;
                }
                int k = j + 1, l = arr.length - 1;
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        arrList.add(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        k++;
                        l--;
                        while (k < l && arr[j] == arr[j + 1]) k++;
                        while (k < l && arr[k] == arr[k - 1]) l--;                    }
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
            for (int j = i + 1; j < arr.length; j++) {
                int k = j + 1, l = arr.length - 1;
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
