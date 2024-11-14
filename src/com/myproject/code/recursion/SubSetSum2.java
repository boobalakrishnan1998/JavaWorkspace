package com.myproject.code.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3,3};
        ArrayList<Integer> al = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findSubSets(0, arr, al, ans);
        //TODO Understand the logic and work out with the array list types
        System.out.println(ans);
    }

    private static void findSubSets(int ind, int[] arr, ArrayList<Integer> ds, List<List<Integer>> ans) {
        int n = arr.length;
        ans.add(new ArrayList<>(ds));
        for (int i = ind; i < n; i++) {
            if (i != ind && arr[i] == arr[i - 1]) {
                continue;
            }
            ds.add(arr[i]);
            findSubSets(i + 1, arr, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}
