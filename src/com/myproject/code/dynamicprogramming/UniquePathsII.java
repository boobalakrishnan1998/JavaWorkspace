package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] maze = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        // Create an instance of Solution class
        UniquePathsII sol = new UniquePathsII();
        // Call the uniquePaths function and print the result
        System.out.println("Number of ways: " + sol.uniquePaths(m, n, maze));
    }

    private int uniquePaths(int m, int n, int[][] maze) {
        // Return the total count (0-based indexing)
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }
        return funcTab(m, n, dp, maze);
    }

    private int func(int i, int j, int[][] maze) {
        if (i == 0 && j == 0) return 1;

        if (i > 0 && j > 0 || maze[i][j] == 1) {
            return 0;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        int left = func(i, j - 1, maze);
        int up = func(i - 1, j, maze);
        return left + up;
    }

    private int funcDp(int i, int j, int[][] dp, int[][] maze) {
        if (i == 0 && j == 0) return 1;
        if (i > 0 && j > 0 || maze[i][j] == 1) {
            return 0;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = func(i, j - 1, maze);
        int up = func(i - 1, j, maze);
        return dp[i][j] = left + up;
    }

    //TODO understand this better
    private int funcTab(int m, int n, int[][] dp, int[][] maze) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == 1) {
                    /* If there's an obstacle at the
                    cell, no paths can pass through it*/
                    dp[i][j] = 0;
                    continue;
                }
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

    int funcSpaceOp(int m, int n, int[][] maze) {
        /* Create an array to represent
        the previous row of the grid*/
        int[] prev = new int[n];

        // Iterate through the rows of the grid
        for (int i = 0; i < m; i++) {
            /* Initialize a temporary array to
            represent the current row*/
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0 && maze[i][j] == 1) {
                    /* If there's an obstacle at (i, j),
                    no paths can pass through it*/
                    temp[j] = 0;
                    continue;
                }

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
