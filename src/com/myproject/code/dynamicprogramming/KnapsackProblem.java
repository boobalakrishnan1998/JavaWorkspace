package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] val = {6, 10, 12};
        int[] wt = {1, 2, 3};
        int W = 5;
        int ans = findMaxValue(val, wt, W);
        System.out.println(ans);
    }

    public static int findMaxValue(int[] val, int[] wt, int W) {
        int[][] dp = new int[val.length][W + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int n = val.length;
        int ans = funcSpace(val, wt, W);
        return ans;
    }

    private static int funcSpace(int[] val, int[] wt, int W) {
        int[] prev = new int[W + 1];
        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }
        for (int ind = 1; ind < val.length; ind++) {
            int[] cur = new int[W + 1];
            for (int capacity = 0; capacity <= W; capacity++) {
                int notPick = prev[capacity];
                int pick = 0;
                if (wt[ind] <= capacity) {
                    pick = val[ind] + prev[capacity - wt[ind]];
                }
                cur[capacity] = Math.max(pick, notPick);
            }
            prev=cur;
        }
        return prev[W];
    }

    private static int funcTab(int[] val, int[] wt, int W) {
        int[][] dp = new int[val.length][W + 1];
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }
        for (int ind = 1; ind < val.length; ind++) {
            for (int capacity = 0; capacity <= W; capacity++) {
                int notPick = dp[ind - 1][capacity];
                int pick = 0;
                if (wt[ind] <= capacity) {
                    pick = val[ind] + dp[ind - 1][capacity - wt[ind]];
                }
                dp[ind][capacity] = Math.max(pick, notPick);
            }
        }
        return dp[val.length - 1][W];
    }

    private static int funcMem(int ind, int[] val, int[] wt, int W, int[][] dp) {
        if (ind == 0) {
            if (wt[0] <= W) return wt[0];
            return 0;
        }
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }
        int notPick = func(ind - 1, val, wt, W);
        int pick = 0;
        if (wt[ind] <= W) {
            pick = val[ind] + func(ind - 1, val, wt, W - wt[ind]);
        }
        return dp[ind][W] = Math.max(pick, notPick);
    }

    private static int func(int ind, int[] val, int[] wt, int W) {
        if (ind == 0) {
            if (wt[0] <= W) return wt[0];
            return 0;
        }
        int notPick = func(ind - 1, val, wt, W);
        int pick = 0;
        if (wt[ind] <= W) {
            pick = val[ind] + func(ind - 1, val, wt, W - wt[ind]);
        }
        return Math.max(pick, notPick);
    }
}
