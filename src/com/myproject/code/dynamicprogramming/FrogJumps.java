package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class FrogJumps {
    public static void main(String[] args) {
        int[] heights = {15, 4, 1, 14, 15};
        int result = frogJump(heights);
        System.out.println("Minimum energy required: " + result);

        int k = 3;
        int ans = frogKJump(heights, k);
        System.out.println("Minimum energy required for K Jump: " + ans);
    }

    private static int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n + 1]; // Initialize dp array
        Arrays.fill(dp, -1);
        // return frogJumpsDp(n - 1, heights, dp);
        return frogJumpsSpaceOp(n, heights);
    }

    private static int frogKJump(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n + 1]; // Initialize dp array
        Arrays.fill(dp, -1);
        return frogKJumpsTab(n , heights, k, dp);
    }

    private static int frogKJumps(int n, int[] heights, int k) {
        if (n == 0) return 0;
        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j < k; j++) {
            if (n - j >= 0) {
                int step = frogKJumps(n - j, heights, k) + abs(heights[n] - heights[n - j]);
                minSteps = min(minSteps, step);
            }
        }
        return minSteps;
    }

    private static int frogKJumpsTab(int n, int[] heights, int k, int[] dp) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int step = dp[i - j] + abs(heights[i] - heights[i - j]);
                    minSteps = min(minSteps, step);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n - 1];
    }

    private static int frogKJumpsMemo(int n, int[] heights, int k, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) {
            return dp[n];
        }
        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j < k; j++) {
            if (n - j >= 0) {
                int step = frogKJumpsMemo(n - j, heights, k, dp) + abs(heights[n] - heights[n - j]);
                minSteps = min(minSteps, step);
            }
        }
        dp[n] = minSteps;
        return minSteps;
    }

    private static int frogJumps(int n, int[] heights) {
        if (n == 0) return 0;
        int first = frogJumps(n - 1, heights) + abs(heights[n] - heights[n - 1]);
        int second = Integer.MAX_VALUE;
        if (n > 1) {
            second = frogJumps(n - 2, heights) + abs(heights[n] - heights[n - 2]);
        }
        return min(first, second);
    }

    private static int frogJumpsDp(int n, int[] heights, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) {
            return dp[n];
        }
        int first = frogJumps(n - 1, heights) + abs(heights[n] - heights[n - 1]);
        int second = Integer.MAX_VALUE;
        if (n > 1) {
            second = frogJumps(n - 2, heights) + abs(heights[n] - heights[n - 2]);
        }
        return dp[n] = min(first, second);
    }

    private static int frogJumpsTab(int n, int[] heights) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int first = dp[i - 1] + abs(heights[i] - heights[i - 1]);
            int second = Integer.MAX_VALUE;
            if (i > 1) {
                second = dp[i - 2] + +abs(heights[i] - heights[i - 2]);
            }
            dp[i] = min(first, second);
        }
        return dp[n - 1];
    }

    private static int frogJumpsSpaceOp(int n, int[] heights) {
        int cur = 0;
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int fs = prev + abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = prev2 + abs(heights[i] - heights[i - 2]);
            }
            cur = min(fs, ss);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

}
