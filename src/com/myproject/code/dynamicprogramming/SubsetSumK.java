package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class SubsetSumK {
    public static void main(String[] args) {
        int target = 6;
        int[] arr = {1, 2, 7, 3};
        boolean ans = subsetSum(arr, target);
        System.out.println(ans);
    }

    private boolean funcSpaceOp(int n, int target, int[] arr) {
        /* Initialize an array 'prev' to store
        the previous row of the DP table*/
        boolean[] prev = new boolean[target + 1];

        /* Base case: If the target sum is 0, we
        can always achieve it by taking no elements*/
        prev[0] = true;

        /* Base case: If the first element of
        'arr' is less than or equal to 'target'*/
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }

        /* Iterate through the elements
        of 'arr' and update the DP table*/
        for (int ind = 1; ind < n; ind++) {
            /* Initialize a new array 'cur' to store
            the current state of the DP table*/
            boolean[] cur = new boolean[target + 1];

            /* Base case: If the target sum is 0, we
            can achieve it by taking no elements*/
            cur[0] = true;

            for (int i = 1; i <= target; i++) {
                /* If we don't take the current element, the
                result is the same as the previous row*/
                boolean notTaken = prev[i];

                /* If we take the current element, subtract its
                value from the target and check the previous row*/
                boolean taken = false;
                if (arr[ind] <= i) {
                    taken = prev[i - arr[ind]];
                }

                /* Store the result in the current DP
                table row for the current subproblem*/
                cur[i] = notTaken || taken;
            }

            /* Update 'prev' with the current
            row 'cur' for the next iteration*/
            prev = cur;
        }

        // The final result is stored in prev[target]
        return prev[target];
    }

    private static boolean subsetSum(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int[] curDp : dp) {
            Arrays.fill(curDp, -1);
        }
        //return funcSum(arr.length - 1, arr, target);
        return funcSumTab(arr, dp,target);
    }

    private static boolean funcSumTab( int[] arr, int[][] dp, int k) {
        for (int i = 0; i < arr.length; i++){
            dp[i][0] = 1;
        }
        dp[0][arr[0]] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int tar = 1; tar <= k; tar++) {
                int nonPick = dp[i - 1][tar];
                int pick = 0;
                if (arr[i] <= tar) {
                    pick = dp[i - 1][tar - arr[i]];
                }
                dp[i][tar] = nonPick == 1 || pick == 1 ? 1 : 0;
            }
        }
        return dp[arr.length - 1][k] == 1;
    }

    private static boolean funcSumDp(int ind, int[] arr, int target, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (ind == 0) {
            return arr[0] == target;
        }
        if (dp[ind][target] != -1) {
            return Boolean.parseBoolean(String.valueOf(dp[ind][target]));
        }
        boolean nonPick = funcSumDp(ind - 1, arr, target, dp);
        boolean pick = false;
        if (arr[ind] <= target) {
            pick = funcSumDp(ind - 1, arr, target - arr[ind], dp);
        }
        boolean ans = nonPick || pick;
        if (ans) {
            dp[ind][target] = 1;
        } else {
            dp[ind][target] = 0;
        }
        return ans;
    }

    private static boolean funcSum(int ind, int[] arr, int target) {
        if (target == 0) {
            return true;
        }
        if (ind == 0) {
            return arr[0] == target;
        }
        boolean nonPick = funcSum(ind - 1, arr, target);
        boolean pick = false;
        if (arr[ind] <= target) {
            pick = funcSum(ind - 1, arr, target - arr[ind]);
        }
        return nonPick || pick;
    }
}
