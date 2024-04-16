package com.myproject.code.arrayConcept;

import java.util.HashMap;
import java.util.Map;

public class MajorityElements {
    public static void main(String[] args) {
        int[] a = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityEle(a));

        System.out.println(longestLenOfSubArr(a));
    }

    //optimal solutions
    private static int majorityEle(int[] nums) {
        int element = nums[0];
        int count = 0;
        for (int j : nums) {
            if (count == 0) {
                element = j;
                count++;
            } else if (element == j) {
                count++;
            } else {
                count--;
            }
        }
        int eleCount = 0;
        //if array contains majority elements surly we can ignore this loop
        for (int j : nums) {
            if (j == element) {
                eleCount++;
            }
        }
        if (eleCount > (nums.length / 2)) {
            return element;
        }
        return -1;
    }

    //better solutions
    private static int longestLenOfSubArr(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : A) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > (A.length / 2)) {
                return m.getKey();
            }
        }
        return -1;
    }
}
