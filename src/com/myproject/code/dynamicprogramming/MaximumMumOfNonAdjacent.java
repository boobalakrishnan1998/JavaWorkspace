package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

import static java.lang.Math.max;

public class MaximumMumOfNonAdjacent {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        // Call the nonAdjacent function and print the result
        System.out.println(nonAdjacent(arr));
    }

    public static int nonAdjacent(int[] nums) {
        int ind = nums.length - 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        // Return the maximum sum
        return funcSpaceOp(nums);
    }

    private static int func(int ind, int[] nums) {
        if (ind <= -1) return 0;
        if (ind == 0) return nums[0];
        int pick = nums[ind] + func(ind - 2, nums);
        int notPick = func(ind - 1, nums);
        return max(pick, notPick);
    }

    private static int funcDp(int ind, int[] nums, int[] dp) {
        if (ind <= -1) return 0;
        if (ind == 0) return nums[0];
        if (dp[ind] != -1) {
            return dp[ind];
        }
        int pick = nums[ind] + func(ind - 2, nums);
        int notPick = func(ind - 1, nums);
        return dp[ind] = max(pick, notPick);
    }

    private static int funcTab(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // Base case
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick += dp[i - 2];
            }
            int notPick = dp[i - 1];
            dp[i] = max(pick, notPick);
        }
        return dp[n - 1];
    }

    private static int funcSpaceOp(int[] nums) {
        int n = nums.length;
        // Base case
        int prev = nums[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick += prev2;
            }
            int notPick = prev;
            int cur = max(pick, notPick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
