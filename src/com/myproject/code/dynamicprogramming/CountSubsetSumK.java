package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class CountSubsetSumK {
    public static void main(String[] args) {
        int target = 3;
        int[] arr = {1, 2, 7, 3};
        int ans = subsetSum(arr, target);
        System.out.println(ans);
    }

    private static int subsetSum(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int[] curDp : dp) {
            Arrays.fill(curDp, -1);
        }
        //return funcSum(arr.length - 1, arr, target);
        //return funcSumDp(arr.length - 1, arr, target, dp);
        //return funcSumTab(arr, target);
        return funcSpaceOp(arr.length,target,arr);
    }

    private static int funcSpaceOp(int n, int target, int[] arr) {
        /* Initialize an array 'prev' to store
        the previous row of the DP table*/
        int[] prev = new int[target + 1];

        /* Base case: If the target sum is 0, we
        can always achieve it by taking no elements*/
        prev[0] = 1;

        /* Base case: If the first element of
        'arr' is less than or equal to 'target'*/
        if (arr[0] <= target) {
            prev[arr[0]] = 1;
        }

        /* Iterate through the elements
        of 'arr' and update the DP table*/
        for (int ind = 1; ind < n; ind++) {
            /* Initialize a new array 'cur' to store
            the current state of the DP table*/
            int[] cur = new int[target + 1];

            /* Base case: If the target sum is 0, we
            can achieve it by taking no elements*/
            cur[0] = 1;

            for (int i = 1; i <= target; i++) {
                /* If we don't take the current element, the
                result is the same as the previous row*/
                int notTaken = prev[i];

                /* If we take the current element, subtract its
                value from the target and check the previous row*/
                int taken = 0;
                if (arr[ind] <= i) {
                    taken = prev[i - arr[ind]];
                }

                /* Store the result in the current DP
                table row for the current subproblem*/
                cur[i] = notTaken + taken;
            }

            /* Update 'prev' with the current
            row 'cur' for the next iteration*/
            prev = cur;
        }

        // The final result is stored in prev[target]
        return prev[target];
    }

    private static int funcSumTab(int[] arr, int k) {
        int[][] dp = new int[arr.length][k + 1];
        for (int i = 0; i < arr.length; i++) {
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
                dp[i][tar] = nonPick + pick;
            }
        }
        return dp[arr.length - 1][k];
    }

    private static int funcSumDp(int ind, int[] arr, int target, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (ind == 0) {
            return arr[0] == target ? 1 : 0;
        }
        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }
        int nonPick = funcSumDp(ind - 1, arr, target, dp);
        int pick = 0;
        if (arr[ind] <= target) {
            pick = funcSumDp(ind - 1, arr, target - arr[ind], dp);
        }
        return dp[ind][target] = nonPick + pick;
    }

    private static int funcSum(int ind, int[] arr, int target) {
        if (target == 0) {
            return 1;
        }
        if (ind == 0) {
            return arr[0] == target ? 1 : 0;
        }
        int nonPick = funcSum(ind - 1, arr, target);
        int pick = 0;
        if (arr[ind] <= target) {
            pick = funcSum(ind - 1, arr, target - arr[ind]);
        }
        return nonPick + pick;
    }
}
