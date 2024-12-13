package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println("The minimum number of operations required is: " + editDistance(s1, s2));
    }

    public int editDistanceSpaceOp(String start, String target) {
        int n = start.length();
        int m = target.length();

        /* Declare two arrays to store previous
        and current row of edit distances */
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        // Initialize the first row
        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        // Calculate edit distances row by row
        for (int i = 1; i <= n; i++) {
            // Initialize the first column of current row
            cur[0] = i;
            for (int j = 1; j <= m; j++) {
                // If the characters match, no additional cost
                if (start.charAt(i - 1) == target.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                } else {
                    // Take minimum of three choices
                    cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
                }
            }
            // Update the previous row with current row
            System.arraycopy(cur, 0, prev, 0, m + 1);
        }

        // The value at cur[m] contains the edit distance
        return cur[m];
    }

    public static int editDistanceTab(String start, String target) {
        int n = start.length();
        int m = target.length();

        // Create a DP table to store edit distances
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the first row and column
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // Fill in the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If characters match, no additional cost
                if (start.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // Take minimum of three choices
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        // The value at dp[n][m] contains the edit distance
        return dp[n][m];
    }

    public static int editDistance(String start, String target) {
        int n = start.length();
        int m = target.length();
        // Create a DP table to memoize results
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        /* Call the utility function with
        the last indices of both strings*/
        return editDistanceUtil(start, target, n - 1, m - 1, dp);
    }

    private static int editDistanceUtil(String S1, String S2, int i, int j, int[][] dp) {
        // Base cases
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        /* If the result for this state has
        already been calculated, return it*/
        if (dp[i][j] != -1)
            return dp[i][j];

        /* If the characters at the current
        positions match, no operation is needed*/
        if (S1.charAt(i) == S2.charAt(j)) {
            return dp[i][j] = 0 + editDistanceUtil(S1, S2, i - 1, j - 1, dp);
        }
        // Take minimum of three choices
        else {
            return dp[i][j] = 1 + Math.min(editDistanceUtil(S1, S2, i - 1, j - 1, dp),
                    Math.min(editDistanceUtil(S1, S2, i - 1, j, dp),
                            editDistanceUtil(S1, S2, i, j - 1, dp)));
        }
    }

    private static int editDistanceUtil(String S1, String S2, int i, int j) {
        // Base cases
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        /* If the characters at the current
        positions match, no operation is needed*/
        if (S1.charAt(i) == S2.charAt(j)) {
            return 0 + editDistanceUtil(S1, S2, i - 1, j - 1);
        }
        // Take minimum of three choices
        else {
            return 1 + Math.min(editDistanceUtil(S1, S2, i - 1, j - 1),
                    Math.min(editDistanceUtil(S1, S2, i - 1, j),
                            editDistanceUtil(S1, S2, i, j - 1)));
        }
    }

}
