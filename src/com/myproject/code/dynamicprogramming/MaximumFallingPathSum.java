package com.myproject.code.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.max;

public class MaximumFallingPathSum {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };
        // Create an instance of Solution class
        MaximumFallingPathSum sol = new MaximumFallingPathSum();
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
        int maxi = (int) Math.pow(-10, 9);
        for (int i = 0; i < m; i++) {
            int ans = funcDp(n - 1, i, m, dp, matrix);
            maxi = max(ans, maxi);
        }
        //func(n - 1, m - 1, matrix)
        //funcDp(n - 1, m - 1, dp, matrix)
        //funcTab(n, m, dp, matrix);
        return maxi;
    }

    private int func(int i, int j, int m, int[][] matrix) {
        if (j < 0 || j >= m)
            return (int) Math.pow(-10, 9);
        if (i == 0)
            return matrix[0][j];

        int up = matrix[i][j] + func(i - 1, j, m, matrix);
        int leftDia = matrix[i][j] + func(i - 1, j - 1, m, matrix);
        int rightDia = matrix[i][j] + func(i - 1, j + 1, m, matrix);
        return max(up, max(leftDia, rightDia));
    }

    private int funcDp(int i, int j, int m, int[][] dp, int[][] matrix) {
        if (j < 0 || j >= m)
            return (int) Math.pow(-10, 9);
        if (i == 0)
            return matrix[0][j];
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = matrix[i][j] + func(i - 1, j, m, matrix);
        int leftDia = matrix[i][j] + func(i - 1, j - 1, m, matrix);
        int rightDia = matrix[i][j] + func(i - 1, j + 1, m, matrix);
        return dp[i][j] = max(up, max(leftDia, rightDia));
    }

    //TODO understand this better
    static int getMaxPathSumTab(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate the maximum path sum for each cell in the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(-10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(-10, 9);
                }

                // Store the maximum of the three paths in dp
                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }

        // Find the maximum value in the last row of dp
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }

        return maxi;
    }

    static int getMaxPathSumSpace(List<List<Integer>> matrix) {
        int n = matrix.size();
        int m = matrix.get(0).size();

        List<Integer> prev = new ArrayList<>(Collections.nCopies(m, 0));
        List<Integer> cur = new ArrayList<>(Collections.nCopies(m, 0));

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            prev.set(j, matrix.get(0).get(j));
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix.get(i).get(j) + prev.get(j);

                int leftDiagonal = matrix.get(i).get(j);
                if (j - 1 >= 0) {
                    leftDiagonal += prev.get(j - 1);
                } else {
                    leftDiagonal += -1e9;
                }

                int rightDiagonal = matrix.get(i).get(j);
                if (j + 1 < m) {
                    rightDiagonal += prev.get(j + 1);
                } else {
                    rightDiagonal += -1e9;
                }

                // Store the maximum of the three paths in cur
                cur.set(j, Math.max(up, Math.max(leftDiagonal, rightDiagonal)));
            }

            // Update the prev list with the values from the cur list for the next row
            prev = new ArrayList<>(cur);
        }

        int maxi = Integer.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, prev.get(j));
        }

        return maxi;
    }
}
