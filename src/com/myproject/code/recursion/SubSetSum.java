package com.myproject.code.recursion;

import java.util.ArrayList;

public class SubSetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<Integer> al = new ArrayList<>();
        subSetSum(0, arr, 0);
        //TODO work out with the array list types
        // subSeqSum(0, arr, al, 0, 3);
        //System.out.println(isSubSeqSum(0, arr, al, 0, 3));
        // System.out.println(countSubSeqSum(0, arr, al, 0, 1));
        //System.out.println(subSeqList(0, arr, al));
    }

    private static void subSetSum(int i, int[] arr, int sum) {
        int n = arr.length;
        if (i == n) {
            System.out.print(" " + sum);
            return;
        }
        subSetSum(i + 1, arr, sum + arr[i]);
        subSetSum(i + 1, arr, sum);
    }
}
