package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int n = arr.length;
        System.out.println("The minimum number of operations are " + matrixMultiplication(arr, n));
    }

    static int matrixMultiplicationTab(int[] arr, int N) {
        int[][] dp = new int[N][N];
        // Initialize the dp array with -1
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        // Initialize the diagonal with 0
        for (int i = 1; i < N; i++) {
            dp[i][i] = 0;
        }
        // Fill in the dp array using bottom-up approach
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i + 1; j < N; j++) {
                int minOperations = Integer.MAX_VALUE;

                // Partitioning loop to find the optimal split point
                for (int k = i; k <= j - 1; k++) {
                    int operations = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    minOperations = Math.min(minOperations, operations);
                }
                dp[i][j] = minOperations;
            }
        }
        // The result is stored in dp[1][N-1]
        return dp[1][N - 1];
    }

    static int f(int arr[], int i, int j, int[][] dp) {
        // base condition
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        // partioning loop
        for (int k = i; k <= j - 1; k++) {
            int ans = f(arr, i, k, dp) + f(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
            mini = Math.min(mini, ans);
        }
        return mini;
    }

    static int f(int[] arr, int i, int j) {
        // base condition
        if (i == j) return 0;
        int mini = Integer.MAX_VALUE;
        // partioning loop
        for (int k = i; k <= j - 1; k++) {
            int ans = f(arr, i, k) + f(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            mini = Math.min(mini, ans);
        }
        return mini;
    }

    static int matrixMultiplication(int[] arr, int N) {

        int[][] dp = new int[N][N];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int i = 1;
        int j = N - 1;
        return f(arr, i, j, dp);
    }
}
