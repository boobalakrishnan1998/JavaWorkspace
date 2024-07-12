package com.myproject.code.arrayConcept;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int cows = 4;
        int[] stalls = new int[]{0, 3, 4, 7, 10, 9};
        int maxStalls = findAggressiveCows(stalls, stalls.length, cows);
        System.out.println(maxStalls);
        int maxStalls1 = findAggressiveCowsBetter(stalls, stalls.length, cows);
        System.out.println(maxStalls1);

    }

    private static int findAggressiveCows(int[] stalls, int n, int k) {
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;//ans and high both are same if it cross
    }

    private static boolean canWePlace(int[] stalls, int dist, int k) {
        int cowCount = 1;
        int lastCow = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if ((stalls[i] - lastCow) >= dist) {
                lastCow = stalls[i];
                cowCount++;
            }
            if (cowCount >= k) {
                return true;
            }
        }
        return false;
    }
    private static int findAggressiveCowsBetter(int[] stalls, int n, int k) {
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n-1];
        int ans =1;
        while(low<=high)
        {
            int mid = low+((high-low)/2);

            if(canWePlace(stalls,mid, k))
            {
                low = mid+1;
                ans= mid;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}