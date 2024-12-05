package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

import static java.lang.Math.min;

public class TriangleMinimumPathSum {
    public static void main(String[] args) {
        int[][] triangle = {
                {1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}
        };
        // Create an instance of Solution class
        TriangleMinimumPathSum sol = new TriangleMinimumPathSum();
        // Call the uniquePaths function and print the result
        System.out.println("Number of ways: " + sol.uniquePaths(triangle));
    }

    private int uniquePaths(int[][] triangle) {
        int n = triangle.length;
        int m = triangle[0].length;
        // Return the total count (0-based indexing)
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        //func(0, 0, triangle)
        //funcDp(0, 0, dp, triangle)
        //funcTab(n, m, dp, triangle);
        return funcSpaceOp(n, triangle);
    }

    private int func(int i, int j, int[][] triangle) {
        if (i == triangle.length - 1) return triangle[i][j];
        int down = triangle[i][j] + func(i + 1, j, triangle);
        int downDia = triangle[i][j] + func(i + 1, j + 1, triangle);
        return min(down, downDia);
    }

    private int funcDp(int i, int j, int[][] dp, int[][] triangle) {
        if (i == triangle.length - 1) return triangle[i][j];
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = triangle[i][j] + func(i + 1, j, triangle);
        int downDia = triangle[i][j] + func(i + 1, j + 1, triangle);
        return dp[i][j] = min(down, downDia);
    }

    private int funcTab(int n, int[][] dp, int[][] triangle) {
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + dp[i + 1][j];
                int downDia = triangle[i][j] + dp[i + 1][j + 1];
                dp[i][j] = min(down, downDia);
            }
        }
        return dp[0][0];
    }

    private int funcSpaceOp(int n, int[][] triangle) {
        int[] front = new int[n];
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            front[i] = triangle[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + front[j];
                int downDia = triangle[i][j] + front[i + 1];
                cur[j] = min(down, downDia);
            }
            front = cur;
        }
        return front[0];
    }
}
