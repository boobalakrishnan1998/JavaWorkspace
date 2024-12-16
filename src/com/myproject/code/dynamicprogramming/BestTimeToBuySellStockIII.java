package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class BestTimeToBuySellStockIII {
    public static void main(String[] args) {
        int[] price = {9, 2, 6, 4, 7, 3};
        int noOfTrades = 2;
        int ans = stockBuySellSpaceOp(price, noOfTrades);
        System.out.println(ans);
    }

    //ToDo using no of transaction with only two params
    private static int findMax(int[] price, int noOfTrades) {
        int[][][] dp = new int[price.length][2][noOfTrades + 1];
        for (int i = 0; i < price.length; i++) {
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }
        return stockBuySellDp(0, 0, price, noOfTrades, dp);
        // return stockBuySell(0, 0, price, noOfTrades);
    }

    public static int stockBuySellSpaceOp(int[] price, int noOfTrades) {
        int n = price.length;
        int[][] ahead = new int[2][noOfTrades + 1];
        for (int ind = n - 1; ind >= 0; ind--) {
            int[][] cur = new int[2][noOfTrades + 1];
            for (int isBuy = 0; isBuy <= 1; isBuy++) {
                for (int cap = 1; cap <= noOfTrades; cap++) {
                    int Profit;
                    if (isBuy == 0) {
                        int buy = -price[ind] + ahead[1][cap];
                        int notBuy = ahead[0][cap];
                        Profit = Math.max(buy, notBuy);
                    } else {
                        int sell = price[ind] + ahead[0][cap - 1];
                        int notSell = ahead[1][cap];
                        Profit = Math.max(sell, notSell);
                    }
                    cur[isBuy][cap] = Profit;
                }
            }
            ahead = cur;
        }
        return ahead[0][noOfTrades];
    }

    public static int stockBuySellTab(int[] price, int noOfTrades) {
        int[][][] dp = new int[price.length + 1][2][noOfTrades + 1];
        int n = price.length;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int isBuy = 0; isBuy <= 1; isBuy++) {
                for (int trade = 1; trade <= noOfTrades; trade++) {
                    int Profit;
                    if (isBuy == 0) {
                        int buy = -price[ind] + dp[ind + 1][1][trade];
                        int notBuy = dp[ind + 1][0][trade];
                        Profit = Math.max(buy, notBuy);
                    } else {
                        int sell = price[ind] + dp[ind + 1][0][trade - 1];
                        int notSell = dp[ind + 1][1][trade];
                        Profit = Math.max(sell, notSell);
                    }
                    dp[ind][isBuy][trade] = Profit;
                }
            }
        }
        return dp[0][0][noOfTrades];
    }

    public static int stockBuySellDp(int ind, int isBuy, int[] price, int noOfTrades, int[][][] dp) {
        if (noOfTrades == 0) return 0;
        if (ind == price.length - 1) {
            return 0;
        }
        if (dp[ind][isBuy][noOfTrades] != -1) {
            return dp[ind][isBuy][noOfTrades];
        }
        int buyProfit = 0;
        int sellProfit = 0;
        if (isBuy == 0) {
            int buy = -price[ind] + stockBuySellDp(ind + 1, 1, price, noOfTrades, dp);
            int notBuy = stockBuySellDp(ind + 1, 0, price, noOfTrades, dp);
            buyProfit = Math.max(buy, notBuy);
        } else {
            int sell = price[ind] + stockBuySellDp(ind + 1, 0, price, noOfTrades - 1, dp);
            int notSell = stockBuySellDp(ind + 1, 1, price, noOfTrades, dp);
            sellProfit = Math.max(sell, notSell);
        }
        return dp[ind][isBuy][noOfTrades] = Math.max(buyProfit, sellProfit);
    }

    public static int stockBuySell(int ind, int isBuy, int[] price, int noOfTrades) {
        if (noOfTrades == 0) return 0;
        if (ind == price.length - 1) {
            return 0;
        }
        int buyProfit = 0;
        int sellProfit = 0;
        if (isBuy == 0) {
            int buy = -price[ind] + stockBuySell(ind + 1, 1, price, noOfTrades);
            int notBuy = stockBuySell(ind + 1, 0, price, noOfTrades);
            buyProfit = Math.max(buy, notBuy);
        } else {
            int sell = price[ind] + stockBuySell(ind + 1, 0, price, noOfTrades - 1);
            int notSell = stockBuySell(ind + 1, 1, price, noOfTrades);
            sellProfit = Math.max(sell, notSell);
        }
        return Math.max(buyProfit, sellProfit);
    }
}
