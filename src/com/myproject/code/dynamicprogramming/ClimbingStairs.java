package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5; // stairs number
        int[] dp = new int[n + 1]; // Initialize dp array
        Arrays.fill(dp, -1); // Fill dp array with -1
        System.out.println(climStairs(n));
        System.out.println(climStairsMo(n, dp));
        System.out.println(climStairsTab(n, dp));
        System.out.println(climStairsSpaceOp(n, dp));
    }

    private static int climStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int first = climStairs(n - 1);
        int second = climStairs(n - 2);
        return first + second;

    }

    private static int climStairsMo(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int first = climStairs(n - 1);
        int second = climStairs(n - 2);
        dp[n] = first + second;
        return first + second;
    }

    private static int climStairsTab(int n, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int climStairsSpaceOp(int n, int[] dp) {
        int first = 1;
        int second = 1;
        int steps = 0;
        for (int i = 2; i <= n; i++) {
            steps = first + second;
            second = first;
            first = steps;
        }
        return steps;
    }
}
