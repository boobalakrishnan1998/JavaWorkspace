package com.myproject.code.recursion;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<Integer> al = new ArrayList<>();
        //subSeq(0, arr, al);
        //subSeqSum(0, arr, al, 0, 3);
        //System.out.println(isSubSeqSum(0, arr, al, 0, 3));
       // System.out.println(countSubSeqSum(0, arr, al, 0, 1));
        System.out.println(subSeqList(0, arr, al));
    }

    private static void subSeq(int i, int[] arr, ArrayList<Integer> al) {
        int n = arr.length;
        if (i == n) {
            System.out.println(al);
            return;
        }
        subSeq(i + 1, arr, al);
        al.add(arr[i]);
        subSeq(i + 1, arr, al);
        al.remove(al.size() - 1);
    }

    private static void subSeqSum(int i, int[] arr, ArrayList<Integer> al, int sum, int target) {
        int n = arr.length;
        if (i == n) {
            if (sum == target) {
                System.out.println(al);
            }
            return;
        }
        sum += arr[i];
        al.add(arr[i]);
        subSeqSum(i + 1, arr, al, sum, target);
        sum -= arr[i];
        al.remove(al.size() - 1);
        subSeqSum(i + 1, arr, al, sum, target);
    }

    private static boolean isSubSeqSum(int i, int[] arr, ArrayList<Integer> al, int sum, int target) {
        int n = arr.length;
        if (i == n) {
            if (sum == target) {
                System.out.println(al);
                return true;
            }
            return false;
        }
        sum += arr[i];
        al.add(arr[i]);
        if (isSubSeqSum(i + 1, arr, al, sum, target)) {
            return true;
        }
        sum -= arr[i];
        al.remove(al.size() - 1);
        if (isSubSeqSum(i + 1, arr, al, sum, target)) {
            return true;
        }
        return false;
    }

    private static int countSubSeqSum(int i, int[] arr, ArrayList<Integer> al, int sum, int target) {
        int n = arr.length;
        if (i == n) {
            if (sum == target) {
                System.out.println(al);
                return 1;
            }
            return 0;
        }
        sum += arr[i];
        al.add(arr[i]);
        int left = countSubSeqSum(i + 1, arr, al, sum, target);
        sum -= arr[i];
        al.remove(al.size() - 1);
        int right = countSubSeqSum(i + 1, arr, al, sum, target);
        return left + right;
    }

    static ArrayList<Integer> subSeqList(int i, int[] arr, ArrayList<Integer> al) {
        int n = arr.length;
        if (i == n) {
            ArrayList<Integer> list = new ArrayList<>(al);
            list.add(0);
            return list;
        }
        ArrayList<Integer> rightList = subSeqList(i + 1, arr, al);
        al.add(arr[i]);
        ArrayList<Integer> leftList = subSeqList(i + 1, arr, al);
        al.remove(al.size() - 1);
        rightList.addAll(leftList);
        return rightList;
    }
}
