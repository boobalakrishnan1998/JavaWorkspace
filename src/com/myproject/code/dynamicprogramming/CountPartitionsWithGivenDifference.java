package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class CountPartitionsWithGivenDifference {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        int diff = 3;
        int ans = subsetSum(arr, diff);
        System.out.println(ans);
    }

    private static int subsetSum(int[] arr, int diff) {
        int totSum = 0;

        // Calculate the total sum of elements in the array.
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }

        /* If the total sum minus the difference is negative,
           or if it is not even, it's not possible to divide
           the array into two subsets with the given difference. */
        if (totSum - diff < 0) return 0;
        if ((totSum - diff) % 2 == 1) return 0;

        // Calculate the target sum for one of the subsets.
        int s2 = (totSum - diff) / 2;
        int[][] dp = new int[arr.length][s2 + 1];
        for (int[] curDp : dp) {
            Arrays.fill(curDp, -1);
        }
        //return funcSum(arr.length - 1, arr, target);
        //return funcSumDp(arr.length - 1, arr, target, dp);
        //return funcSumTab(arr, target);
        return funcSpaceOp(s2, arr);
    }

    private static int funcSpaceOp(int tar, int[] num) {
        int n = num.length;

        /* DP table to store number of ways
           to achieve a certain target sum. */
        int[] prev = new int[tar + 1];

        /* 2 cases for target 0 when the first
           element is 0: either pick it or not. */
        if (num[0] == 0) prev[0] = 2;
        /* 1 case for target 0 when the first
           element is non-zero: just don't pick it. */
        else prev[0] = 1;

        /* Initialize the base case for the
           first element and non-zero target. */
        if (num[0] != 0 && num[0] <= tar) prev[num[0]] = 1;

        /* Iterate through the elements
        of 'arr' and update the DP table*/
        for (int ind = 1; ind < n; ind++) {
            /* Initialize a new array 'cur' to store
            the current state of the DP table*/
            int[] cur = new int[tar + 1];

            /* Base case: If the target sum is 0, we
            can achieve it by taking no elements*/
            cur[0] = 1;

            for (int i = 1; i <= tar; i++) {
                /* If we don't take the current element, the
                result is the same as the previous row*/
                int notTaken = prev[i];

                /* If we take the current element, subtract its
                value from the target and check the previous row*/
                int taken = 0;
                if (num[ind] <= i) {
                    taken = prev[i - num[ind]];
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
        return prev[tar];
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
        if (ind == 0) {
            /* If target is 0 and the element is also 0, there
            are 2 ways to achieve this (include or exclude). */
            if (target == 0 && arr[0] == 0)
                return 2;

            /* If target is 0 or the element is equal to
            target, there is 1 way to achieve this. */
            if (target == 0 || target == arr[0])
                return 1;

            return 0;
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
        if (ind == 0) {
            /* If target is 0 and the element is also 0, there
            are 2 ways to achieve this (include or exclude). */
            if (target == 0 && arr[0] == 0)
                return 2;

            /* If target is 0 or the element is equal to
            target, there is 1 way to achieve this. */
            if (target == 0 || target == arr[0])
                return 1;

            return 0;
        }
        int nonPick = funcSum(ind - 1, arr, target);
        int pick = 0;
        if (arr[ind] <= target) {
            pick = funcSum(ind - 1, arr, target - arr[ind]);
        }
        return nonPick + pick;
    }
}
