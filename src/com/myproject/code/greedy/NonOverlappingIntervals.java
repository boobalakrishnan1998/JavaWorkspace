package com.myproject.code.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    // Function to count the maximum number of non-overlapping intervals
    public int MaximumNonOverlappingIntervals(int[][] intervals) {
        // Sort the intervals based on their ending times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        // Get total number of intervals
        int n = intervals.length;

        // Initialize counter
        int cnt = 1;

        // Keep track of the ending time
        int lastEndTime = intervals[0][1];

        // Iterate through all intervals
        for (int i = 1; i < n; i++) {
            /* Check if the starting time of the current
            interval is greater than or equal to
            the ending time of the last
            selected interval */
            if (intervals[i][0] >= lastEndTime) {
                // Increment counter
                cnt++;
                // Update the ending time
                lastEndTime = intervals[i][1];
            }
        }
        return n - cnt;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals obj = new NonOverlappingIntervals();
        int[][] intervals = {{0, 5}, {3, 4}, {1, 2}, {5, 9}, {7, 9}};

        for (int i = 0; i < intervals.length; i++) {
            System.out.println("Interval " + (i + 1) + " Start: " + intervals[i][0] + " End: " + intervals[i][1]);
        }

        int ans = obj.MaximumNonOverlappingIntervals(intervals);
        System.out.println("Maximum Non-Overlapping Intervals: " + ans);
    }
}
