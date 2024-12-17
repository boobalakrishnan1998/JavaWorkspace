package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int ans = longestIncSubSpaceOp(arr);
        System.out.println(ans);

    }

    private static int findLen(int[] arr) {
        int[][] dp = new int[arr.length][arr.length + 1];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return longestIncSubDp(0, -1, arr, dp);
    }

    static int longestIncreasingSubsequence(int arr[], int n){

        int dp[]=new int[n];
        Arrays.fill(dp,1);

        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){

                if(arr[prev_index]<arr[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev_index]);
                }
            }
        }

        int ans = -1;

        for(int i=0; i<=n-1; i++){
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }


    private static int longestIncSubSpaceOp(int[] arr) {
        int[] next = new int[arr.length + 1];
        int n = arr.length;
        for (int ind = n - 1; ind >= 0; ind--) {
            int[] cur = new int[arr.length + 1];
            for (int prev_ind = ind - 1; prev_ind >= -1; prev_ind--) {
                int notPickLen = next[prev_ind + 1];
                int pick = 0;
                if (prev_ind == -1 || arr[ind] > arr[prev_ind]) {
                    pick = 1 + next[ind + 1];
                }
                cur[prev_ind + 1] = Math.max(notPickLen, pick);
            }
            next = cur;
        }
        return next[0];
    }

    private static int longestIncSubTab(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        int n = arr.length;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev_ind = ind - 1; prev_ind >= -1; prev_ind--) {
                int notPickLen = dp[ind + 1][prev_ind + 1];
                int pick = 0;
                if (prev_ind == -1 || arr[ind] > arr[prev_ind]) {
                    pick = 1 + dp[ind + 1][ind + 1];
                }
                dp[ind][prev_ind + 1] = Math.max(notPickLen, pick);
            }
        }
        return dp[0][0];
    }

    private static int longestIncSubDp(int ind, int prev_ind, int[] arr, int[][] dp) {
        if (ind == arr.length) {
            return 0;
        }
        if (dp[ind][prev_ind + 1] != -1) {
            return dp[ind][prev_ind + 1];
        }
        int notPickLen = longestIncSub(ind + 1, prev_ind, arr);
        int pick = 0;
        if (prev_ind == -1 || arr[ind] > arr[prev_ind]) {
            pick = 1 + longestIncSub(ind + 1, ind, arr);
        }
        return dp[ind][prev_ind + 1] = Math.max(notPickLen, pick);
    }

    private static int longestIncSub(int ind, int prev_ind, int[] arr) {
        if (ind == arr.length) {
            return 0;
        }
        int notPickLen = longestIncSub(ind + 1, prev_ind, arr);
        int pick = 0;
        if (prev_ind == -1 || arr[ind] > arr[prev_ind]) {
            pick = 1 + longestIncSub(ind + 1, ind, arr);
        }
        return Math.max(notPickLen, pick);
    }


}
