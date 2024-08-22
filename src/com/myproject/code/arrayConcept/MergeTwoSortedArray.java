package com.myproject.code.arrayConcept;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = nums2.length;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;
        while (left >= 0 && right <= n - 1) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
            } else {
                break;
            }
            left--;
            right++;
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
    }
}
