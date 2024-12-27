package com.myproject.code.greedy;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 4}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {5, 8};
        System.out.print("Intervals Array: ");
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "], ");
        }
        System.out.println();
        System.out.print("New Interval to be Inserted: ");
        System.out.println("[" + newInterval[0] + ", " + newInterval[1] + "]");
        int[][] result = insertNewInterval(intervals, newInterval);
        System.out.print("Resulting Intervals after Insertion: ");
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "], ");
        }
        System.out.println();
    }

    public static int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
        // Initialize a list to store the result
        List<int[]> res = new ArrayList<>();

        /* Track the index while
        iterating through
        intervals */
        int i = 0;

        // Get total intervals
        int n = intervals.length;

        // Insert intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            /* Add intervals to the result list
            until their end time is before
            the start time of newInterval */

            res.add(intervals[i]);
            // Move to next interval
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            /* Update the start time of newInterval to the
            minimum of its current start time and the
            start time of the current interval */
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);

            /* Update the end time of newInterval to the
            maximum of its current end time and the
            end time of the current interval */
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            // Move to the next interval
            i++;
        }

        /* Insert the merged interval
        Add the merged interval to
        the result list */
        res.add(newInterval);

        /* Insert remaining
        intervals after
        newInterval */
        while (i < n) {
            /* Add the remaining intervals
            after newInterval to the result
            list */
            res.add(intervals[i]);

            // Move to next interval
            i++;
        }

        // Convert the result list to a 2D array and return
        return res.toArray(new int[res.size()][]);
    }
}
