package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

import static java.lang.Math.max;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        // Create an instance of Solution class
        NinjaTraining sol = new NinjaTraining();
        // Print the maximum points for ninja training
        System.out.println(sol.ninjaTraining(points));
    }

    private int ninjaTraining(int[][] points) {
        int[][] dp = new int[points.length][points[0].length+1];
        for (int[] point : dp) {
            Arrays.fill(point, -1);
        }
        int ans = funcDb(points.length - 1, points[0].length, points, dp);
        return ans;
    }
    //TODO understand Tab and SpaceOp
    public int funcSpaceOp(int[][] matrix) {
        int n = matrix.length;

         /* Initialize a vector to store the maximum
        points for the previous day's activities*/
        int[] prev = new int[4];

        // Initialize the prev array for the first day (day 0)
        prev[0] = Math.max(matrix[0][1], matrix[0][2]);
        prev[1] = Math.max(matrix[0][0], matrix[0][2]);
        prev[2] = Math.max(matrix[0][0], matrix[0][1]);
        prev[3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        // Iterate through the days starting from day 1
        for (int day = 1; day < n; day++) {
            /* Initialize a temporary vector to store the
            maximum points for the current day's activities*/
            int[] temp = new int[4];

            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                // Iterate through the tasks for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        /* Calculate the points for the current activity
                        and add it to the maximum points obtained on the
                        previous day (stored in prev)*/
                        temp[last] = Math.max(temp[last], matrix[day][task] + prev[task]);
                    }
                }
            }

            // Update prev with maximum points for the current day
            prev = temp;
        }

        /* The maximum points for the last day with
        any activity can be found in prev[3]*/
        return prev[3];
    }
    public int funcTab(int[][] matrix) {
        int n = matrix.length;
        // Create a 2D DP table to store the maximum points
        int[][] dp = new int[n][4];

        // Initialize the DP table for the first day (day 0)
        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        // Iterate through the days starting from day 1
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                // Iterate through the tasks for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        /* Calculate the points for the current
                        activity and add it to the maximum points
                        obtained on the previous day */
                        int activity = matrix[day][task] + dp[day - 1][task];

                        /* Update the maximum points for
                        the current day and last activity*/
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        /* The maximum points for the last day with
        any activity can be found in dp[n-1][3]*/
        return dp[n - 1][3];
    }
    private int funcDb(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) {
            return dp[day][last];
        }
        if (day == 0) {
            int maxZero = 0;
            for (int i = 0; i < points[0].length; i++) {
                if (i != last) {
                    maxZero = max(maxZero, points[day][i]);
                }
            }
            return dp[day][last] = maxZero;
        }
        int maxPoints = 0;
        for (int i = 0; i < points.length; i++) {
            if (i != last) {
                int max = func(day - 1, i, points) + points[day][i];
                maxPoints = max(maxPoints, max);

            }
        }
        return dp[day][last] = maxPoints;
    }

    private int func(int day, int last, int[][] points) {
        if (day == 0) {
            int maxZero = 0;
            for (int i = 0; i < points[0].length; i++) {
                if (i != last) {
                    maxZero = max(maxZero, points[day][i]);
                }
            }
            return maxZero;
        }
        int maxPoints = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (i != last) {
                int max = func(day - 1, i, points) + points[day][i];
                maxPoints = max(maxPoints, max);
            }
        }
        return maxPoints;
    }
}
