package com.myproject.code.arrayConcept;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] ans = productExceptSelf(nums1);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int subProduct=1;
        for (int i = n - 2; i >= 0; i--) {
            subProduct*=nums[i + 1];
            ans[i] *= subProduct;
        }
        return ans;
    }

    public static int[] productExceptSelfWithExtraSpace(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
