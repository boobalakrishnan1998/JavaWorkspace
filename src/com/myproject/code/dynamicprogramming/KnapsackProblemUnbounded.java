package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class KnapsackProblemUnbounded {
    public static void main(String[] args) {
        int[] val = {5, 11, 13};
        int[] wt = {2, 4, 6};
        int W = 10;
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
        int[] cur = new int[W + 1];
        for (int i = wt[0]; i <= W; i++) {
            cur[i] = (i / wt[0]) * val[0];
        }
        for (int ind = 1; ind < val.length; ind++) {
            for (int capacity = 0; capacity <= W; capacity++) {
                int notPick = cur[capacity];
                int pick = 0;
                if (wt[ind] <= capacity) {
                    pick = val[ind] + cur[capacity - wt[ind]];
                }
                cur[capacity] = Math.max(pick, notPick);
            }
        }
        return cur[W];
    }

    private static int funcTab(int[] val, int[] wt, int W) {
        int[][] dp = new int[val.length][W + 1];
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = (i / wt[0]) * val[0];
        }
        for (int ind = 1; ind < val.length; ind++) {
            for (int capacity = 0; capacity <= W; capacity++) {
                int notPick = dp[ind - 1][capacity];
                int pick = 0;
                if (wt[ind] <= capacity) {
                    pick = val[ind] + dp[ind][capacity - wt[ind]];
                }
                dp[ind][capacity] = Math.max(pick, notPick);
            }
        }
        return dp[val.length - 1][W];
    }

    private static int funcMem(int ind, int[] val, int[] wt, int W, int[][] dp) {
        if (ind == 0) {
           return (W / wt[0]) * val[0];
        }
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }
        int notPick = funcMem(ind - 1, val, wt, W,dp);
        int pick = 0;
        if (wt[ind] <= W) {
            pick = val[ind] + funcMem(ind , val, wt, W - wt[ind],dp);
        }
        return dp[ind][W] = Math.max(pick, notPick);
    }

    private static int func(int ind, int[] val, int[] wt, int W) {
        if (ind == 0) {
            return (W / wt[0]) * val[0];
        }
        int notPick = func(ind - 1, val, wt, W);
        int pick = 0;
        if (wt[ind] <= W) {
            pick = val[ind] + func(ind, val, wt, W - wt[ind]);
        }
        return Math.max(pick, notPick);
    }
}
