package com.myproject.code.stack;

import java.util.Stack;

public class NextSmallerElement {
    public static void main(String args[]) {
        int arr[] = {5, 7, 1, 2, 6, 0};

        int arr2[] = nextSmallerElementsOnCircularArray(arr);
        System.out.println("The next Smaller elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }

    private static int[] nextSmallerElements(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.add(arr[i]);
        }
        return ans;
    }

    private static int[] nextSmallerElementsOnCircularArray(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        int n = arr.length;
        for (int i = 0; i < 2 * n ; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i % n]) {
                st.pop();
            }
            if (i > n) {
                if (st.isEmpty()) {
                    ans[i % n] = -1;
                } else {
                    ans[i % n] = st.peek();
                }
            }
            st.add(arr[i % n]);
        }
        return ans;
    }

}
