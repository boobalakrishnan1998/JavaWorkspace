package com.myproject.code.slidingwindow;

import java.util.Arrays;
import java.util.Stack;

public class MaximumOfMinimumForEveryWindowSize {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 10, 70, 30};
        int[] ans = maxMinWindow(arr, arr.length);
        System.out.println(Arrays.toString(ans));
    }
    // O(n)
    public static int[] maxMinWindow(int[] arr, int n) {
        // answer[i] will store the maximum of minimum for every window size
        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MIN_VALUE);
        // next[i] will store the index of next smaller element which lie on the right hand side of it
        int[] next = nextSmaller(arr, n);
        // prev[i] will store the index of previous smaller element which lie on the left hand side of it
        int[] prev = previousSmaller(arr, n);
        //before underStand how this approach is works
        //we need to pick max for the window size soo if it max of the both the side then it will be the max of mins to understand it more do dry run with this example
        // you pick element from array and looking where it fits in answer array by looking into the psn and nsm.
        for (int i = 0; i < n; i++) {
            // Length of the window in which a[i] is minimum
            int length = next[i] - prev[i] - 1;
            // Update the answer
            answer[length - 1] = Math.max(answer[length - 1], arr[i]);
        }
        // Some places in answer[] may not be filled yet.
        // so fill them by taking maximum
        for (int i = n - 2; i >= 0; i--) {
            answer[i] = Math.max(answer[i], answer[i + 1]);
        }
        return answer;
    }
    public static int[] previousSmaller(int[] arr, int n) {
        int[] prev = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                prev[i] = -1;
            } else {
                prev[i] = s.peek();
            }
            s.push(i);
        }
        return prev;
    }

    public static int[] nextSmaller(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                next[i] = n;
            } else {
                next[i] = s.peek();
            }
            s.push(i);
        }
        return next;
    }


}

