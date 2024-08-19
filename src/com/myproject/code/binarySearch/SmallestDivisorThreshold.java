package com.myproject.code.binarySearch;

public class SmallestDivisorThreshold {
    public static void main(String[] args) {
        int[] arr = new int[]{44, 22, 33, 11, 1};
        int threshold = 5;
        int ans = smallestDivisor(arr, threshold);
        System.out.println(ans);
    }

    private static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            high = Math.max(high, nums[i]);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isSmallDivisor(nums, mid) > threshold) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int isSmallDivisor(int[] arr, int mid) {
        int divisorCount = 0;
        for (int i = 0; i < arr.length; i++) {
            divisorCount += (int) Math.ceil((double) arr[i] / mid);//(x+y-1)/y
        }
        return divisorCount;
    }
}
