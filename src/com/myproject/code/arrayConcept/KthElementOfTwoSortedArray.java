package com.myproject.code.arrayConcept;

public class KthElementOfTwoSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        int[] arr1 = new int[]{7, 12, 14, 15};
        int[] arr2 = new int[]{1, 2, 3, 4, 9, 11};
        int n = arr1.length;
        int m = arr2.length;
        int k = 3;
        System.out.println(getKthElement(k, arr1, arr2));
        System.out.println(getMeddleByPointerMethod(n, m, k, arr1, arr2));

    }

    private static int getMeddleByPointerMethod(int n, int m, int k, int[] a, int[] b) {
        if (n > m) return getMeddleByPointerMethod(m, n, k, b, a);
        int low = Math.max(0, k - m);
        int high = Math.min(n, k);
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = k - mid1;
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1];
            int r1 = mid1 == n ? Integer.MAX_VALUE : a[mid1];
            int r2 = mid2 == m ? Integer.MAX_VALUE : b[mid2];
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 1;
    }

    public static int getKthElement(int key, int arr1[], int arr2[]) {

        int i = 0, j = 0, k = 0;
        int[] sum = new int[key];
        while (k < key) {
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
        return sum[key - 1];
    }


}
