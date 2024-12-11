package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] price = {1, 6, 8, 9, 10, 19, 7, 20};
        int N = 8;
        int ans = findMaxValue(price, N);
        System.out.println(ans);
    }

    public static int findMaxValue(int[] price, int N) {
        int[][] dp = new int[price.length][N + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = funcSpace(price, N);
        return ans;
    }

    private static int funcSpace(int[] price, int N) {
        int[] cur = new int[N + 1];
        for (int i = N; i <= N; i++) {
            cur[i] = N * price[0];
        }
        for (int ind = 1; ind < price.length; ind++) {
            for (int capacity = 0; capacity <= N; capacity++) {
                int notPick = cur[capacity];
                int pick = 0;
                int rodLen = ind + 1;
                if (rodLen <= capacity) {
                    pick = price[ind] + cur[capacity - rodLen];
                }
                cur[capacity] = Math.max(pick, notPick);
            }
        }
        return cur[N];
    }

    private static int funcTab(int[] price, int N) {
        int[][] dp = new int[price.length][N + 1];
        for (int i = N; i <= N; i++) {
            dp[0][i] = N * price[0];
        }
        for (int ind = 1; ind < price.length; ind++) {
            for (int capacity = 0; capacity <= N; capacity++) {
                int notPick = dp[ind - 1][capacity];
                int pick = 0;
                int rodLen = ind + 1;
                if (rodLen <= capacity) {
                    pick = price[ind] + dp[ind][capacity - rodLen];
                }
                dp[ind][capacity] = Math.max(pick, notPick);
            }
        }
        return dp[price.length - 1][N];
    }

    private static int funcMem(int ind, int[] price, int N, int[][] dp) {
        if (ind == 0) {
            return N * price[0];
        }
        if (dp[ind][N] != -1) {
            return dp[ind][N];
        }
        int notPick = funcMem(ind - 1, price, N, dp);
        int pick = 0;
        int rodLen = ind + 1;
        if (rodLen <= N) {
            pick = price[ind] + funcMem(ind, price, N - rodLen, dp);
        }
        return dp[ind][N] = Math.max(pick, notPick);
    }

    private static int func(int ind, int[] price, int N) {
        if (ind == 0) {
            return N * price[0];
        }
        int notPick = func(ind - 1, price, N);
        int pick = 0;
        int rodLen = ind + 1;
        if (rodLen <= N) {
            pick = price[ind] + func(ind, price, N - rodLen);
        }
        return Math.max(pick, notPick);
    }
}
