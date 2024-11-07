package com.myproject.code.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<Integer> al = new ArrayList<>();
        findCombination(0, 3, arr, al);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinationList(0, 3, arr, al, ans);
        System.out.println(ans);
    }

    private static void findCombination(int i, int target, int[] arr, ArrayList<Integer> ds) {
        int n = arr.length;
        if (i == n) {
            if (target == 0) {
                System.out.println(ds);
            }
            return;
        }
        if (arr[i] <= target) {
            ds.add(arr[i]);
            findCombination(i, target - arr[i], arr, ds);
            ds.remove(ds.size() - 1);
        }
        findCombination(i + 1, target, arr, ds);
    }

    private static void findCombinationList(int i, int target, int[] arr, ArrayList<Integer> ds, List<List<Integer>> ans) {
        int n = arr.length;
        if (i == n) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[i] <= target) {
            ds.add(arr[i]);
            findCombinationList(i, target - arr[i], arr, ds, ans);
            ds.remove(ds.size() - 1);
        }
        findCombinationList(i + 1, target, arr, ds, ans);
    }
}
