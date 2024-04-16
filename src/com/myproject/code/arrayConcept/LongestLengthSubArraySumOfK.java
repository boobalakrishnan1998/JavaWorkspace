package com.myproject.code.arrayConcept;

import java.util.HashMap;
import java.util.Map;

public class LongestLengthSubArraySumOfK {
    public static void main(String[] args) {
        int[] a = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(longestLenOfSubArr(a, k));
        System.out.println(longestLenOfSubArrWithPositiveNumOnly(a, k));
    }

    private static int longestLenOfSubArrWithPositiveNumOnly(int[] a, int k) {
        long sum = a[0];
        int longLen = 0;
        int left = 0;
        int right = 0;
        int n = a.length;
        while (right < n) {
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }
            if (sum == k) {
                longLen = Math.max(longLen, right - left + 1);
            }
            right++;
            if (right < n){
                sum += a[right];
            }
        }
        return longLen;
    }

    //optimal solutions for negative and positive numbers
    //better solutions for positive number only
    private static int longestLenOfSubArr(int[] A, int K) {
        int n = A.length; // size of the array.
        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += A[i];
            // if the sum = k, update the maxLen:
            if (sum == K) {
                maxLen = Math.max(maxLen, i + 1);
            }
            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - K;
            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            //Finally, update the map checking the conditions:
            //this conditions to handle negative number
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
}
