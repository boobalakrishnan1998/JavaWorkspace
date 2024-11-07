package com.myproject.code.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2};
        ArrayList<Integer> al = new ArrayList<>();
        findCombination(0, 4, arr, al);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinationList(0, 4, arr, al, ans);
        System.out.println(ans);
    }

    private static void findCombination(int ind, int target, int[] arr, ArrayList<Integer> ds) {
        int n = arr.length;
        if (target == 0) {
            System.out.println(ds);
            return;
        }
        for (int i = ind; i < n; i++) {
            if (i > ind && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            ds.add(arr[i]);
            findCombination(i + 1, target - arr[i], arr, ds);
            ds.remove(ds.size() - 1);

        }
    }

    private static void findCombinationList(int ind, int target, int[] arr, ArrayList<Integer> ds, List<List<Integer>> ans) {
        int n = arr.length;
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < n; i++) {
            if (i > ind && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            ds.add(arr[i]);
            findCombinationList(i + 1, target - arr[i], arr, ds, ans);
            ds.remove(ds.size() - 1);

        }
    }
}
