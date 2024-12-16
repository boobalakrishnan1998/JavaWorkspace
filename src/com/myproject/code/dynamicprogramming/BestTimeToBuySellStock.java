package com.myproject.code.dynamicprogramming;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] arr = {7, 8, 5, 3, 6, 4};
        int ans = findMax(arr);
        System.out.println(ans);
    }

    private static int findMax(int[] arr) {
        int n = arr.length;
        int min = 0;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxProfit = Math.max(maxProfit, arr[i] - arr[min]);
            if (arr[min] > arr[i]) {
                min = i;
            }
        }
        return maxProfit;
    }
    public int stockBuySell(int[] arr, int n) {
        int maxProfit = 0;
        // Initialize mini to the first element of arr
        int mini = arr[0];
        // Traverse through the array
        for (int i = 1; i < n; i++) {
            // Calculate current profit
            int curProfit = arr[i] - mini;
            // Update maxProfit if curProfit is larger
            maxProfit = Math.max(maxProfit, curProfit);
            // Update mini to minimum value encountered so far
            mini = Math.min(mini, arr[i]);
        }
        // Return the maximum profit
        return maxProfit;
    }

}
