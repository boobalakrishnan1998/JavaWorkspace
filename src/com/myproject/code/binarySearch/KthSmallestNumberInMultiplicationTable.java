package com.myproject.code.binarySearch;

public class KthSmallestNumberInMultiplicationTable {
    public static void main(String[] args) {
        int m = 2, n = 3, k = 6;
        int ans = findKthSmallestElement(m, n, k);
        System.out.println(ans);
    }

    private static int findKthSmallestElement(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isSmallestNumber(mid, n, m) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int isSmallestNumber(int mid, int n, int m) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }
        return count;
    }
}
