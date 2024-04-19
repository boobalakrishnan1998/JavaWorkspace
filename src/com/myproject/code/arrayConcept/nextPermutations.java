package com.myproject.code.arrayConcept;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class nextPermutations {
    public static void main(String[] args) {
        Integer[] arr = {2, 1, 5, 4, 3, 0, 0};
        int[] ar = {2, 1, 5, 4, 3, 0, 0};
        List<Integer> a = Arrays.asList(arr);
        System.out.println(findNextPermutations(a));
        System.out.println(Arrays.toString(findNextPermutations(ar)));
    }

    private static int[] findNextPermutations(int[] a) {
        int n = a.length;
        int index = -1;
        for (int i = n - 2; i >=0; i--) {
            if (a[i] < a[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return reverse(a, 0, n - 1);
        }
        for (int i = n - 1; i > index; i--) {
            if (a[index] < a[i]) {
                int temp = a[index];
                a[index] = a[i];
                a[i] = temp;
                break;
            }
        }
        reverse(a, index + 1, n - 1);
        return a;
    }

    public static int[] reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
        return a;
    }

    private static List<Integer> findNextPermutations(List<Integer> a) {
        int n = a.size();
        int index = -1;
        for (int i = n - 2; i > 0; i--) {
            if (a.get(i) < a.get(i + 1)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Collections.reverse(a);
            return a;
        }

        for (int i = n - 1; i > index; i--) {
            if (a.get(i) > a.get(index)) {
                int temp = a.get(i);
                a.set(i, a.get(index));
                a.set(index, temp);
                break;
            }
        }
        Collections.reverse(a.subList(index + 1, n));
        return a;
    }
}
