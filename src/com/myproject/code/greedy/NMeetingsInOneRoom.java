package com.myproject.code.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        // Start and end times of the meetings
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        // Get the maximum number of meetings that can be held
        int maxMeetings = maxMeetings(start, end);
        // Output the maximum number of meetings
        System.out.println("Maximum number of meetings: " + maxMeetings);
    }


    // Function to find the maximum number of meetings that can be held
    public static int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        // List to store meetings
        List<int[]> meetings = new ArrayList<>();

        // Fill the meetings list with start and end times
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{start[i], end[i]});
        }

        // Sort the meetings based on the custom comparator
        Collections.sort(meetings, new MeetingComparator());

        // The end time of last selected meeting
        int limit = meetings.get(0)[1];
        // Initialize count
        int count = 1;

        /*Iterate through the meetings
        to select the maximum number
        of non-overlapping meetings*/
        for (int i = 1; i < n; i++) {
            /*If the current meeting starts
            after the last selected meeting ends*/
            if (meetings.get(i)[0] > limit) {
                /*Update the limit to the end
                time of the current meeting*/
                limit = meetings.get(i)[1];
                // Increment count
                count++;
            }
        }

        // Return count
        return count;
    }

    static class MeetingComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            // Sort by end time in ascending order
            return Integer.compare(a[1], b[1]);
        }
    }
}
