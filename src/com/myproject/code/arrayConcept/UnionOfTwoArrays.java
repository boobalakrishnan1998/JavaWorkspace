package com.myproject.code.arrayConcept;

import java.util.*;

public class UnionOfTwoArrays {
    public static void main(String[] args) {
        //unsorted array
        int[] arr1 = {1, 4, 3, 2, 5};
        int[] arr2 = {3, 2, 1};
        System.out.print(findUnion(arr1, arr2));
        //sorted array
        int[] a = {1,2,3,4,5};
        int[] b = {1, 2, 3};
        System.out.println(findUnionSorted(a, b));
    }

    private static Stack<Integer> findUnionSorted(int[] a, int[] b) {
        int an = a.length;
        int bn = b.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < an && j < bn) {
            if (a[i] <= b[j]) {
                if (stack.isEmpty() || a[i] != stack.peek()) {
                    stack.push(a[i]);
                }
                i++;
            } else {
                if (stack.isEmpty() || b[j] != stack.peek()) {
                    stack.push(b[j]);
                }
                j++;
            }
        }
        while (i < an) {
            if (stack.isEmpty() || a[i] != stack.peek()) {
                stack.push(a[i]);
                i++;
            }

        }
        while (j < bn) {
            if (stack.isEmpty() || b[j] != stack.peek()) {
                stack.push(b[j]);
                j++;
            }
        }
        return stack;
    }


    private static int findUnion(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        int an = a.length;
        int bn = b.length;
        int min = Math.min(an, bn);
        for (int i = 0; i < min; i++) {
            set.add(a[i]);
            set.add(b[i]);
        }
        if (an > min) {
            for (int i = min; i < an; i++) {
                set.add(a[i]);
            }
        }
        if (bn > min) {
            for (int i = min; i < bn; i++) {
                set.add(b[i]);
            }
        }
        return set.size();
    }
}
