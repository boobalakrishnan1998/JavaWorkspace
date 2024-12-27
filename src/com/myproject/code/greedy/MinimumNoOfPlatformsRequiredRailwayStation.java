package com.myproject.code.greedy;

import java.util.Arrays;

public class MinimumNoOfPlatformsRequiredRailwayStation {
    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        System.out.println("Minimum number of Platforms required: " + findPlatform(arr, dep));
    }

    public static int findPlatform(int[] Arrival, int[] Departure) {//Optimal
        int n = Arrival.length;
        // Sort both arrival and departure arrays
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int ans = 1;
        int count = 1;
        int i = 1, j = 0;
        // Iterate through the arrays
        while (i < n && j < n) {
            if (Arrival[i] <= Departure[j]) {
                // Increment count
                count++;
                i++;
            } else {
                // Decrement count
                count--;
                j++;
            }
            // Find maximum
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public int findPlatformBF(int[] Arrival, int[] Departure) {
        int n = Arrival.length;

        /* Initialize the variable
        to store the maximum
        number of platforms
        needed initialised with 1
        since at least one
        train will require
        one platform */
        int ans = 1;

        // Outer loop to iterate each arrival time
        for (int i = 0; i < n; i++) {

            /* Initialize the count of
            overlapping intervals for
            the current train initialised
            with 1 since the current train
            itself requires one platform */
            int count = 1;

            /* Inner loop to compare the
            current train with all other trains */
            for (int j = i + 1; j < n; j++) {
                /* Check if there is an overlap between
                the current train (i) and another train (j)

                There is an overlap if:

                1. The arrival time of train i is between the
                arrival and departure times of train j

                2. OR the arrival time of train j is between
                the arrival and departure times of train i */
                if ((Arrival[i] >= Arrival[j] && Arrival[i] <= Departure[j]) ||
                        (Arrival[j] >= Arrival[i] && Arrival[j] <= Departure[i])) {

                    // Increment count
                    count++;
                }
            }

            /* Update the maximum number
            of platforms needed.
            This keeps track of the
            highest count of
            overlapping trains
            found so far */
            ans = Math.max(ans, count);
        }

        // Return number of platforms
        return ans;
    }

}
