package com.myproject.code.arrayConcept;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArraySumKadanesAlgorithm {
    public static void main(String[] args) {
        int[] a = {1,2,3,-2,5};
        System.out.println(maximumSubArraySum(a));
    }

    //optimal solution
    private static long maximumSubArraySum(int[] a) {
        long maxi = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            int start = 0;
            if (sum == 0) {
                start = i;
            }
            if (sum > maxi) {
                //if they ask index
                int maxStart = start;
                int maxEnd = i;
                maxi = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }

    //better solutions for positive number only
    public static int maxSubarraySum(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // current subarray = arr[i.....j]

                //add the current element arr[j]
                // to the sum i.e. sum of arr[i...j-1]
                sum += arr[j];

                maxi = Math.max(maxi, sum); // getting the maximum
            }
        }

        return maxi;
    }}
