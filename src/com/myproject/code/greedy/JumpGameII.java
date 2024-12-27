package com.myproject.code.greedy;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 1, 2};
        System.out.print("Array representing maximum jump from each index: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        int ans = jump(nums);
        System.out.println("Number of jump to reach the last index." + ans);
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int n = nums.length;
        int l = 0, r = 0, jumps = 0, farthest = 0;

        while (r <= n - 1) {


            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
                if (farthest >= n - 1) {
                    return jumps + 1;
                }
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }
}
