package com.myproject.code.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
*Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]*/
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
        // Input: nums = [0,1, 2, 3,4,5,6,7], k = 3
        int[] ans = new int[nums.length - (k - 1)];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= (i - k)) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                ans[index++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }


}

