package com.myproject.code.arrayConcept;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int x = 11;
        int[] arr = {2, 5, 1, 7, 6};
        int[] ans = findTwoSumOptimal(arr, x);//optimal approach
        //int[] ans=findTwoSumBruteForce(arr, x);//Brute force approach
        //int[] ans=findTwoSumBetter(arr, x);//better approach

        System.out.println(Arrays.toString(ans));
    }

    private static int[] findTwoSumOptimal(int[] nums, int target) {
        int n = nums.length;
        int[][] elematrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            elematrix[i][0] = nums[i];
            elematrix[i][1] = i;
        }
      /*  Arrays.sort(elematrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        Arrays.sort(elematrix, (o1, o2) -> Integer.compare(o1[0], o2[0]));*/
        Arrays.sort(elematrix, Comparator.comparingInt(o -> o[0]));
        int left = 0, right = n - 1;
        while (left < right) {
            int curSum = elematrix[left][0] + elematrix[right][0];
            if (curSum == target) {
                return new int[]{elematrix[left][1], elematrix[right][1]};
            } else if (curSum < target) {
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] findTwoSumBetter(int[] arr, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int a : arr) {
            int target = x - a;
            if (map.containsKey(target)) {
                return new int[]{map.get(target), i};
            }
            map.put(a, i++);
        }
        return new int[]{-1, -1};
    }

    public static int[] findTwoSumBruteForce(int[] arr, int x) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == x) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
