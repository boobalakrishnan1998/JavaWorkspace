package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class BestTimeToBuySellStockII {
    public static void main(String[] args) {
        int[] price = {9, 2, 6, 4, 7, 3};
        int ans = stockBuySellSpaceOp(price);
        System.out.println(ans);
    }

    private static int findMax(int[] price) {

        int[][] dp = new int[price.length][2];
        for (int i = 0; i < price.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return stockBuySellDp(0, true, price, dp);
    }

    public static int stockBuySellSpaceOp(int[] price) {
        int n = price.length;
        int[] ahead = new int[2];
        for (int ind = n - 1; ind >= 0; ind--) {
            int[] cur = new int[2];
            for (int isBuy = 0; isBuy <= 1; isBuy++) {
                int Profit;
                if (isBuy == 1) {
                    int buy = -price[ind] + ahead[0];
                    int notBuy = ahead[1];
                    Profit = Math.max(buy, notBuy);
                } else {
                    int sell = price[ind] + ahead[1];
                    int notSell = ahead[0];
                    Profit = Math.max(sell, notSell);
                }
                cur[isBuy] = Profit;
            }
            ahead = cur;
        }
        return ahead[1];
    }


    public static int stockBuySellTab(int[] price) {
        int[][] dp = new int[price.length + 1][2];
        int n = price.length;
        dp[n][0] = 0;
        dp[n][1] = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int isBuy = 0; isBuy <= 1; isBuy++) {
                int Profit;
                if (isBuy == 1) {
                    int buy = -price[ind] + dp[ind + 1][0];
                    int notBuy = dp[ind + 1][1];
                    Profit = Math.max(buy, notBuy);
                } else {
                    int sell = price[ind] + dp[ind + 1][1];
                    int notSell = dp[ind + 1][0];
                    Profit = Math.max(sell, notSell);
                }
                dp[ind][isBuy] = Profit;
            }
        }
        return dp[0][1];
    }

    public static int stockBuySellDp(int ind, boolean isBuy, int[] price, int[][] dp) {
        if (ind == price.length - 1) {
            return 0;
        }
        int buyVal = isBuy ? 1 : 0;
        if (dp[ind][buyVal] != -1) {
            return dp[ind][buyVal];
        }
        int buyProfit = 0;
        int sellProfit = 0;
        if (isBuy) {
            int buy = -price[ind] + stockBuySellDp(ind + 1, false, price, dp);
            int notBuy = stockBuySellDp(ind + 1, true, price, dp);
            buyProfit = Math.max(buy, notBuy);
        } else {
            int sell = price[ind] + stockBuySellDp(ind + 1, true, price, dp);
            int notSell = stockBuySellDp(ind + 1, false, price, dp);
            sellProfit = Math.max(sell, notSell);
        }
        return dp[ind][buyVal] = Math.max(buyProfit, sellProfit);
    }

    public static int stockBuySell(int ind, boolean isBuy, int[] price) {
        if (ind == price.length - 1) {
            return 0;
        }
        int buyProfit = 0;
        int sellProfit = 0;
        if (isBuy) {
            int buy = -price[ind] + stockBuySell(ind + 1, false, price);
            int notBuy = stockBuySell(ind + 1, true, price);
            buyProfit = Math.max(buy, notBuy);
        } else {
            int sell = price[ind] + stockBuySell(ind + 1, true, price);
            int notSell = stockBuySell(ind + 1, false, price);
            sellProfit = Math.max(sell, notSell);
        }
        return Math.max(buyProfit, sellProfit);
    }

}
