package com.myproject.code.slidingwindow;

/*
* Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:*/
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int ans = minSubArrayLen(target, arr);
        System.out.println(ans);
    }

    // O(n)
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minSubArrLen = Integer.MAX_VALUE;
        int sum = 0;
        boolean isFound = false;
        // nums = [2,3,1,2,4,3]
        //0,1,2,3,4,5
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minSubArrLen = Math.min(minSubArrLen, (right - left + 1));
                sum -= nums[left];
                left++;
                isFound = true;
            }
        }
        if (!isFound) {
            return 0;
        }
        return minSubArrLen;
    }


}

