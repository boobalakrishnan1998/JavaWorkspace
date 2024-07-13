package com.myproject.code.arrayConcept;

public class MinDaysToMakeBouquets {

    public static void main(String[] args) {
        int[] bloomDay = new int[]{7, 7, 7, 7, 13, 11, 12, 7};
        int m = 2;
        int k = 3;
        int minDays = minDays(bloomDay, m, k);
        System.out.println(minDays);
    }

    private static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) {
            return -1;
        }
        int low = Integer.MIN_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(bloomDay, mid, m, k) >= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int possible(int[] bloomDay, int mid, int m, int k) {
        int roseCount = 0;
        int bouquetCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                roseCount++;
            } else {
                bouquetCount += roseCount / k;
                roseCount = 0;
            }
        }
        bouquetCount += roseCount / k;
        return bouquetCount;
    }
}
