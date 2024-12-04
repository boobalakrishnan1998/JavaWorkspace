package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class GridUniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        // Create an instance of Solution class
        GridUniquePaths sol = new GridUniquePaths();

        // Call the uniquePaths function and print the result
        System.out.println("Number of ways: " + sol.uniquePaths(m, n));
    }

    private int uniquePaths(int m, int n) {
        // Return the total count (0-based indexing)
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }
        return funcTab(m, n, dp);
    }

    private int func(int i, int j) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) {
            return 0;
        }
        int left = func(i, j - 1);
        int up = func(i - 1, j);
        return left + up;
    }

    private int funcDp(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = func(i, j - 1);
        int up = func(i - 1, j);
        return dp[i][j] = left + up;
    }

    //TODO understand this better
    private int funcTab(int m, int n, int[][] dp) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                dp[i][j] = left + up;
            }
        }
        return dp[m - 1][n - 1];
    }

    int funcSpaceOp(int m, int n) {
        /* Create an array to represent
        the previous row of the grid*/
        int[] prev = new int[n];

        // Iterate through the rows of the grid
        for (int i = 0; i < m; i++) {
            /* Initialize a temporary array to
            represent the current row*/
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                // Base case
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                /* Initialize variables to store the number
                of ways from cell above (up) and left (left)*/
                int up = (i > 0) ? prev[j] : 0;
                int left = (j > 0) ? temp[j - 1] : 0;

                /* Calculate the number of ways to reach
                the current cell by adding 'up' and 'left'*/
                temp[j] = up + left;
            }

            /* Update the previous array with values
            calculated for the current row*/
            prev = temp;
        }

        /* The result is stored in the last
        cell of the previous row (n-1)*/
        return prev[n - 1];
    }
}
