package com.myproject.code.arrayConcept;

public class KoKoEatingBananas {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 15, 6, 3};
        int h = 8;
        int ans = findMinBananas(arr, h);
        System.out.println(ans);
    }

    private static int findMinBananas(int[] arr, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int n = arr.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            high = Math.max(high, arr[i]);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (findHours(arr, mid) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;

            }
        }
        return low;
    }

    private static int findHours(int[] arr, int mid) {
        double totalHours = 0;
        for (int i = 0; i < arr.length; i++) {
            totalHours += Math.ceil((double) arr[i] / (double) mid);
        }
        return (int) totalHours;
    }
}
