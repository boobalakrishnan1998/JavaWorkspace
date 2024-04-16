package com.myproject.code.arrayConcept;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(getMeddle(nums1, nums2));
        int[] arr1 = new int[]{7, 12, 14, 15};
        int[] arr2 = new int[]{1, 2, 3, 4, 9, 11};
        int n = nums1.length;
        int m = nums2.length;
        System.out.println(getMeddleByPointerMethod(n, m, nums1, nums2));

    }

    private static double getMeddleByPointerMethod(int n, int m, int[] a, int[] b) {
        if (n > m) return getMeddleByPointerMethod(m, n, b, a);
        int len = n + m;
        int low = 0;
        int high = n;
        int left = (len + 1) / 2;
        while (low <= high) {
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            if (mid1 < n) r1 = a[mid1];
            if (mid2 < m) r2 = b[mid2];
            if (mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = b[mid2 - 1];
            if (l1 <= r2 && l2 <= r1) {
                if (len % 2 == 0) return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0.0;
    }

    public static double getMeddle(int arr1[], int arr2[]) {

        int i = 0, j = 0, k = 0;
        int totLen = arr1.length + arr2.length;
        int[] sum = new int[totLen];
        while (k < totLen) {
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    sum[k++] = arr1[i++];
                } else {
                    sum[k++] = arr2[j++];
                }
            } else if (i < arr1.length) {
                sum[k++] = arr1[i++];
            } else {
                sum[k++] = arr2[j++];
            }
        }
        return totLen % 2 == 0 ? (double) (sum[totLen / 2] + sum[(totLen - 1) / 2]) / 2 : sum[totLen / 2];
    }


}
