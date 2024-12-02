package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 5; // Fibonacci number to find
        int[] dp = new int[n + 1]; // Initialize dp array
        Arrays.fill(dp, -1); // Fill dp array with -1

        // Output the nth Fibonacci number
        System.out.println(f(n));
        System.out.println(fdp(n, dp));
        System.out.println(fdpOp(n, dp));
        System.out.println(fdpSpaceOp(n));
    }

    private static int f(int n) {
        if (n <= 1) {
            return n;
        }
        return f(n - 1) + f(n - 2);
    }

    private static int fdp(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fdp(n - 1, dp) + fdp(n - 2, dp);
    }

    private static int fdpOp(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int fdpSpaceOp(int n) {
        int first = 1;
        int second = 0;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = first + second;
            second = first;
            first = fib;
        }
        return fib;
    }
}
