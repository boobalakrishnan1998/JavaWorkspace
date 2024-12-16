package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class BestTimeToBuySellStockWithCoolDown {
    public static void main(String[] args) {
        int[] price = {9, 2, 6, 4, 7, 3};
        int noOfTrades = 2;
        int ans = stockBuySellSpaceOp(price, noOfTrades);
        System.out.println(ans);
    }

    //ToDo using no of transaction with only two params
    private static int findMax(int[] price, int noOfTrades) {
        int[][] dp = new int[price.length][2 * noOfTrades + 1];
        for (int i = 0; i < price.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return stockBuySellDp(0, 0, price, noOfTrades, dp);
        //return stockBuySell(0, 0, price, noOfTrades);
    }

    public static int stockBuySellSpaceOp(int[] price, int noOfTrades) {
        int[] after1 = new int[2 * noOfTrades + 1];
        int[] after2 = new int[2 * noOfTrades + 1];
        int n = price.length;
        for (int ind = n - 1; ind >= 0; ind--) {
            int[] cur = new int[2 * noOfTrades + 1];
            for (int transNo = 2 * noOfTrades - 1; transNo >= 0; transNo--) {
                int Profit;
                if (transNo % 2 == 0) {
                    int buy = -price[ind] + after1[transNo + 1];
                    int notBuy = after1[transNo];
                    Profit = Math.max(buy, notBuy);
                } else {
                    int sell = price[ind] + after2[transNo + 1];
                    int notSell = after1[transNo];
                    Profit = Math.max(sell, notSell);
                }
                cur[transNo] = Profit;
            }
            after2 = after1;
            after1 = cur;
        }
        return after1[0];
    }

    public static int stockBuySellTab(int[] price, int noOfTrades) {
        int[][] dp = new int[price.length + 2][2 * noOfTrades + 1];
        int n = price.length;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int transNo = 2 * noOfTrades - 1; transNo >= 0; transNo--) {
                int Profit;
                if (transNo % 2 == 0) {
                    int buy = -price[ind] + dp[ind + 1][transNo + 1];
                    int notBuy = dp[ind + 1][transNo];
                    Profit = Math.max(buy, notBuy);
                } else {
                    int sell = price[ind] + dp[ind + 2][transNo + 1];
                    int notSell = dp[ind + 1][transNo];
                    Profit = Math.max(sell, notSell);
                }
                dp[ind][transNo] = Profit;
            }
        }
        return dp[0][0];
    }

    public static int stockBuySellDp(int ind, int transNo, int[] price, int noOfTrades, int[][] dp) {
        if (ind >= price.length - 1 || transNo == 2 * noOfTrades) {
            return 0;
        }

        if (dp[ind][transNo] != -1) {
            return dp[ind][transNo];
        }
        int buyProfit = 0;
        int sellProfit = 0;
        if (transNo % 2 == 0) {
            int buy = -price[ind] + stockBuySellDp(ind + 1, transNo + 1, price, noOfTrades, dp);
            int notBuy = stockBuySellDp(ind + 1, transNo, price, noOfTrades, dp);
            buyProfit = Math.max(buy, notBuy);
        } else {
            int sell = price[ind] + stockBuySellDp(ind + 2, transNo + 1, price, noOfTrades, dp);
            int notSell = stockBuySellDp(ind + 1, transNo, price, noOfTrades, dp);
            sellProfit = Math.max(sell, notSell);
        }
        return dp[ind][transNo] = Math.max(buyProfit, sellProfit);
    }

    public static int stockBuySell(int ind, int transNo, int[] price, int noOfTrades) {
        if (ind >= price.length - 1 || transNo == 2 * noOfTrades) {
            return 0;
        }
        int buyProfit = 0;
        int sellProfit = 0;
        if (transNo % 2 == 0) {
            int buy = -price[ind] + stockBuySell(ind + 1, transNo + 1, price, noOfTrades);
            int notBuy = stockBuySell(ind + 1, transNo, price, noOfTrades);
            buyProfit = Math.max(buy, notBuy);
        } else {
            int sell = price[ind] + stockBuySell(ind + 2, transNo + 1, price, noOfTrades);
            int notSell = stockBuySell(ind + 1, transNo, price, noOfTrades);
            sellProfit = Math.max(sell, notSell);
        }
        return Math.max(buyProfit, sellProfit);
    }
}
