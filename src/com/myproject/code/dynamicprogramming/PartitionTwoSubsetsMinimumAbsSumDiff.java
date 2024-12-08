package com.myproject.code.dynamicprogramming;

public class PartitionTwoSubsetsMinimumAbsSumDiff {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        // Create an instance of Solution class
        System.out.println("The minimum absolute difference is: " + minDifference(arr, n));
    }

    public static int minDifference(int[] arr, int n) {
        int totSum = 0;
        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }
        /* Initialize a DP table to store the
        results of the subset sum problem */
        boolean[][] dp = new boolean[n][totSum + 1];
        /* Base case: If no elements are
        selected (sum is 0), it's a valid subset */
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        /* Initialize the first row based
        on the first element of the array */
        if (arr[0] <= totSum)
            dp[0][arr[0]] = true;

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= totSum; target++) {
                // Exclude the current element
                boolean notTaken = dp[ind - 1][target];

                /* Include the current element
                if it doesn't exceed the target */
                boolean taken = false;
                if (arr[ind] <= target)
                    taken = dp[ind - 1][target - arr[ind]];

                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                /* Calculate the absolute difference
                between two subset sums */
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        //Return the result
        return mini;
    }
}
