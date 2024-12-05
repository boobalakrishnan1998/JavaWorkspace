package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

import static java.lang.Math.min;

public class MinimumPathSum {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };
        // Create an instance of Solution class
        MinimumPathSum sol = new MinimumPathSum();
        // Call the uniquePaths function and print the result
        System.out.println("Number of ways: " + sol.uniquePaths(matrix));
    }

    private int uniquePaths(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // Return the total count (0-based indexing)
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        //func(n - 1, m - 1, matrix)
        //funcDp(n - 1, m - 1, dp, matrix)
        //funcTab(n, m, dp, matrix);
        return funcSpaceOp(n, m, matrix);
    }

    private int func(int i, int j, int[][] matrix) {
        if (i == 0 && j == 0) return matrix[i][j];
        if (i < 0 || j < 0) {
            return (int) Math.pow(10, 9);
        }
        int up = matrix[i][j] + func(i - 1, j, matrix);
        int left = matrix[i][j] + func(i, j - 1, matrix);
        return min(up, left);
    }

    private int funcDp(int i, int j, int[][] dp, int[][] matrix) {
        if (i == 0 && j == 0) return matrix[i][j];
        if (i < 0 || j < 0) {
            return (int) Math.pow(10, 9);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = matrix[i][j] + func(i - 1, j, matrix);
        int left = matrix[i][j] + func(i, j - 1, matrix);
        return dp[i][j] = min(up, left);
    }

    //TODO understand this better
    private int funcTab(int n, int m, int[][] dp, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                int up = matrix[i][j];
                int left = matrix[i][j];
                if (j > 0) {
                    left += dp[i][j - 1];
                } else {
                    left += (int) Math.pow(10, 9);
                }
                if (i > 0) {
                    up += dp[i - 1][j];
                } else {
                    up += (int) Math.pow(10, 9);
                }
                dp[i][j] = min(left, up);
            }
        }
        return dp[m - 1][n - 1];
    }

    private int funcSpaceOp(int n, int m, int[][] matrix) {
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    cur[j] = matrix[i][j];
                    continue;
                }
                int up = matrix[i][j];
                if (i > 0) {
                    up += prev[j];
                } else {
                    up += (int) Math.pow(10, 9);
                }
                int left = matrix[i][j];
                if (j > 0) {
                    left += cur[j - 1];
                } else {
                    left += (int) Math.pow(10, 9);
                }
                cur[j] = min(left, up);
            }
            prev = cur;
        }
        return prev[m - 1];
    }
}
