package com.myproject.code.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuatationArray {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        ArrayList<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findPermuatation(0, arr, ans);
        boolean[] freq = new boolean[arr.length];
        //findPermuatationBetter(arr, ds, ans, freq);//Normal
        //TODO Understand the logic and work out with the array list types
        System.out.println(ans);
    }

    static void findPermuatation(int ind, Integer[] nums, List<List<Integer>> ans) {
        if (ind == nums.length) {
            List<Integer> list = new ArrayList<>(Arrays.asList(nums));
            ans.add(list);
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            swap(i, ind, nums);
            findPermuatation(ind + 1, nums, ans);
            swap(i, ind, nums);
        }
    }

    private static void swap(int i, int j, Integer[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private static void findPermuatationBetter(Integer[] arr, ArrayList<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        int n = arr.length;
        if (ds.size() == n) {
            ans.add(new ArrayList<>(ds));
        }
        for (int i = 0; i < n; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(arr[i]);
                findPermuatationBetter(arr, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}
