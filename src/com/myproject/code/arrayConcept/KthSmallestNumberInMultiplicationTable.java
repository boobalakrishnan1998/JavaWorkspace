package com.myproject.code.arrayConcept;

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
            if (isSmallestNumber(mid, n, k)) {
                high = mid;

            } else {
                low = mid + 1;

            }
        }
        return low;
    }

    private static boolean isSmallestNumber(int mid, int m, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, m);
        }
        return count >= k;
    }
//TODo understand the correct your program
    public int findKthNumber(int m, int n, int k) {
        int lo=0, hi=m*n;
        while (lo < hi) {
            int mid=(lo+hi)/2, count=0;
            // check how many numbers are smaller than mid
            for (int i=1; i<=m; i++)
                count += n < mid/i ? n : mid/i;
            if (count >= k)  // target <= mid
                hi = mid;
            else  // target > mid
                lo = mid+1;
        }
        return lo;
    }
}
