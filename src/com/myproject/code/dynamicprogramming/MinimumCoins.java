package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class MinimumCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 10;
        System.out.println("The total number of ways is " + minimumCoins(coins, amount));
    }

    private static int minimumCoins(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = findMinCoinsTab(coins, amount);
        if (ans >= 1e9) {
            return -1;
        }
        return ans;
    }

    private static int findMinCoinsSpaceOp(int[] coins, int amount) {
        int[] prev = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (amount % coins[0] == 0) prev[i] = i / coins[0];
            else prev[i] = (int) 1e9;
        }
        for (int ind = 1; ind < coins.length; ind++) {
            int[] cur = new int[amount + 1];
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = prev[tar];
                int take = (int) 1e9;
                if (coins[ind] <= tar) {
                    take = 1 + prev[tar - coins[ind]];
                }
                cur[tar] = Math.min(notTake, take);
            }
            prev = cur;
        }
        return prev[amount];
    }

    private static int findMinCoinsTab(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (amount % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = (int) 1e9;
        }
        for (int ind = 1; ind < coins.length; ind++) {
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = dp[ind - 1][tar];
                int take = (int) 1e9;
                if (coins[ind] <= tar) {
                    take = 1 + dp[ind][tar - coins[ind]];
                }
                dp[ind][tar] = Math.min(notTake, take);
            }
        }
        return dp[coins.length - 1][amount];
    }

    private static int findMinCoinsMem(int ind, int[] coins, int amount, int[][] dp) {
        if (ind == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return (int) 1e9;
        }
        if (dp[ind][amount] != -1) {
            return dp[ind][amount];
        }
        int notTake = findMinCoins(ind - 1, coins, amount);
        int take = (int) 1e9;
        if (coins[ind] <= amount) {
            take = 1 + findMinCoins(ind, coins, amount - coins[ind]);
        }
        return dp[ind][amount] = Math.min(notTake, take);
    }


    private static int findMinCoins(int ind, int[] coins, int amount) {
        if (ind == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return (int) 1e9;
        }
        int notTake = findMinCoins(ind - 1, coins, amount);
        int take = (int) 1e9;
        if (coins[ind] <= amount) {
            take = 1 + findMinCoins(ind, coins, amount - coins[ind]);
        }
        return Math.min(notTake, take);
    }
}
