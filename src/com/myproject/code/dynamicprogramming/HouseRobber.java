package com.myproject.code.dynamicprogramming;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {1, 5, 1, 2, 6};
        System.out.println(houseRobber(arr));
    }

    public static int houseRobber(int[] money) {
        int n = money.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return money[0];

        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];

        // Populate arr1 and arr2
        for (int i = 0; i < n; i++) {
            if (i != n - 1)
                arr1[i] = money[i];
            if (i != 0)
                arr2[i - 1] = money[i];
        }
        int ans1 = func(arr1);

        int ans2 = func(arr2);

        // Return the maximum of ans1 and ans2
        return Math.max(ans1, ans2);
    }

    private static int func(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            // Maximum sum if we pick current element
            int pick = nums[i];

            if (i > 1) {
                // Add the maximum sum two elements ago
                pick += prev2;
            }
            // Maximum sum if we don't pick current element
            int nonPick = 0 + prev;

            // Maximum at the current element
            int cur_i = Math.max(pick, nonPick);

            prev2 = prev;
            prev = cur_i;
        }
        // Return the maximum sum
        return prev;
    }
}
