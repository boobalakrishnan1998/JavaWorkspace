package com.myproject.code.binarySearch;

import java.util.Arrays;

public class KthSmallestDistancePair {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,10};
        int k = 5;
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

            //just assume that SlidingCondition function excute and give us the answer
            if (SlidingCondition(nums, m) >= k) {
                r = m;
            } else {
                l = m + 1;
            }

        }
        return l;

    }


    //simple sliding window
    //remember this is sorted array
    private static int SlidingCondition(int[] nums, int mid) {

        int total = 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {

            //check if distance between two values " <= mid "

            //if anytime our distance becomes greater so we need to increment left pointer (to minimize distance) upto when condition not becomes true
            while (nums[i] - nums[j] > mid) {
                j++;
            }
             //[1,2,5,10]  //left 1 i 3
            //total =2 (10,2) ,(10,5)
            //store  " i - left " index (as this is sorted array)
            //  for left to i index values's all must satisfy (<=mid) condition
            total += i - j;

        }

        return total;
    }
}
