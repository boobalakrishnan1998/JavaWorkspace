package com.myproject.code.arrayConcept;

import java.sql.SQLOutput;
import java.util.Arrays;

public class KthSmallestDistancePair {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 1};
        int k = 3;
        int ans = smallestDistancePair(arr, k);
        System.out.println(ans);
    }

    public static int smallestDistancePair(int[] nums, int k) {

        //sort the array & initialize variable
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];

        //simple binary search
        //check whether value is greater or equal to k (and execute binary search function)
        while (l < r) {
            int m = l + (r - l) / 2;

            //just assume that condition function excute and give us the answer
            if (condition(nums, m) >= k) {
                r = m;
            } else {
                l = m + 1;
            }

        }
        return l;

    }


    //simple sliding window
    //remember this is sorted array
    private static int condition(int[] nums, int mid) {

        int total = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            //check if distance between two values " <= mid "

            //if anytime our distance becomes greater so we need to increment left pointer (to minimize distance) upto when condition not becomes true
            while (nums[right] - nums[left] > mid) {
                left++;
            }

            //store  " right - left " index (as this is sorted array)
            //  for left to right index values's all must satisfy (<=mid) condition
            total += right - left;

        }

        return total;
    }
}
