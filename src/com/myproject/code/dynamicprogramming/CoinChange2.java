package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 2;
        System.out.println("The total number of ways is " + minimumCoins(coins, amount));
    }

    private static int minimumCoins(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = findMinCoins(n - 1, coins, amount);
        return ans;
    }

    private static int findMinCoinsSpaceOp(int[] coins, int amount) {
        int[] prev = new int[amount + 1];
        for (int T = 0; T <= amount; T++) {
            prev[T] = amount % coins[0] == 0 ? 1 : 0;
        }
        for (int ind = 1; ind < coins.length; ind++) {
            int[] cur = new int[amount + 1];
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = prev[tar];
                int take = 0;
                if (coins[ind] <= tar) {
                    take = prev[tar - coins[ind]];
                }
                cur[tar] = notTake + take;
            }
            prev = cur;
        }
        return prev[amount];
    }

    private static int findMinCoinsTab(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int T = 0; T <= amount; T++) {
            dp[0][T] = amount % coins[0] == 0 ? 1 : 0;
        }
        for (int ind = 1; ind < coins.length; ind++) {
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = dp[ind - 1][tar];
                int take = 0;
                if (coins[ind] <= tar) {
                    take = 1 + dp[ind][tar - coins[ind]];
                }
                dp[ind][tar] = notTake + take;
            }
        }
        return dp[coins.length - 1][amount];
    }

    private static int findMinCoinsMem(int ind, int[] coins, int amount, int[][] dp) {
        if (ind == 0) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        if (dp[ind][amount] != -1) {
            return dp[ind][amount];
        }
        int notTake = findMinCoins(ind - 1, coins, amount);
        int take = 0;
        if (coins[ind] <= amount) {
            take = findMinCoins(ind, coins, amount - coins[ind]);
        }
        return dp[ind][amount] = notTake + take;
    }


    private static int findMinCoins(int ind, int[] coins, int amount) {
        if (ind == 0) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        int notTake = findMinCoins(ind - 1, coins, amount);
        int take = 0;
        if (coins[ind] <= amount) {
            take = findMinCoins(ind, coins, amount - coins[ind]);
        }
        return notTake + take;
    }
}
