package com.myproject.code.arrayConcept;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] intArr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = trap(intArr);
        System.out.println(ans);
    }

    public static int trap(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int leftMax = 0, rightMax = 0;
        int totalRain = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (leftMax > height[left]) {
                    totalRain += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]) {
                    totalRain += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;

            }
        }
        return totalRain;
    }

    public static int trapBetter(int[] height) {
        int len = height.length;
        int[] left = prefixArea(height, len);
        int[] right = surfixArea(height, len);
        int maxArea = 0;
        for (int i = 0; i < len - 1; i++) {
            if (height[i] < left[i] &&
                    height[i] < right[i]) {
                maxArea += Math.min(left[i], right[i]) - height[i];
            }
        }
        return maxArea;
    }

    public static int[] prefixArea(int[] height, int len) {
        int[] prefix = new int[len];
        prefix[0] = height[0];
        for (int i = 1; i < len - 1; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }
        return prefix;
    }

    public static int[] surfixArea(int[] height, int len) {
        int[] surfix = new int[len];
        surfix[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            surfix[i] = Math.max(surfix[i + 1], height[i]);
        }
        return surfix;
    }
}
