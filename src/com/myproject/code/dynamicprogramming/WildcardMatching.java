package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class WildcardMatching {
    public static void main(String[] args) {
        String str = "abc";
        String pat = "a?c";
        System.out.println(wildCard(str, pat));  // Output: true
    }

    public static boolean wildCard(String str, String pat) {
        int n = str.length();
        int m = pat.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return wildcardMatchingUtilDp(str, pat, n - 1, m - 1, dp);
    }

    public static boolean wildCardSpaceOp(String str, String pat) {
        int n = str.length();
        int m = pat.length();

        /* Create two arrays to store previous
        and current rows of matching results */
        boolean[] prev = new boolean[m + 1];
        boolean[] cur = new boolean[m + 1];

        /* Initialize the first element
        of the previous row to true */
        prev[0] = true;

        // Initialize the first column
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int ii = 1; ii <= i; ii++) {
                if (str.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            cur[0] = flag;
            for (int j = 1; j <= m; j++) {
                /* If the characters at the current
                positions match or str has a '?' */
                if (str.charAt(i - 1) == pat.charAt(j - 1) || str.charAt(i - 1) == '?') {
                    cur[j] = prev[j - 1];
                } else if (str.charAt(i - 1) == '*') {
                    /* Two options: either '*' represents an
                    empty string or it matches a character in pat */
                    cur[j] = prev[j] || cur[j - 1];
                } else {
                    cur[j] = false;
                }
            }
            prev = Arrays.copyOf(cur, m + 1);
        }
        // Return the result
        return prev[m];
    }

    public static boolean wildCardTab(String str, String pat) {
        int n = str.length();
        int m = pat.length();

        /* Create a DP table for
        memoization, initialized with false */
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // Initialize the first row
        for (int j = 1; j <= m; j++) {
            dp[0][j] = (pat.charAt(j - 1) == '*') && dp[0][j - 1];
        }

        // Initialize the first column
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int ii = 1; ii <= i; ii++) {
                if (str.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                /* If the characters at the current
                positions match or str has a '?' */
                if (str.charAt(i - 1) == pat.charAt(j - 1) || str.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (str.charAt(i - 1) == '*') {
                    /* Two options: either '*' represents an
                    empty string or it matches a character in pat */
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    private static boolean wildcardMatchingUtilDp(String S1, String S2, int i, int j, int[][] dp) {
        // Base Cases
        if (i < 0 && j < 0)
            return true;
        if (i < 0 && j >= 0)
            return false;
        if (j < 0 && i >= 0)
            return isAllStars(S1, i);

        /* If the result for this state has
        already been calculated, return it */
        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean result;

        /* If the characters at the current
        positions match or S1 has a '?' */
        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?') {
            result = wildcardMatchingUtilDp(S1, S2, i - 1, j - 1, dp);
        } else if (S1.charAt(i) == '*') {
            /* Two options: either '*' represents an
            empty string or it matches a character in S2 */
            result = wildcardMatchingUtilDp(S1, S2, i - 1, j, dp) || wildcardMatchingUtilDp(S1, S2, i, j - 1, dp);
        } else {
            result = false;
        }

        /* Memoize the result */
        dp[i][j] = result ? 1 : 0;
        return result;
    }

    /* Function to check if a
    substring of S1 contains only '*' */
    private static boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
            if (S1.charAt(j) != '*')
                return false;
        }
        return true;
    }

    /* Function to check if S1 matches
    S2 using wildcard pattern matching */
    private static boolean wildcardMatchingUtil(String S1, String S2, int i, int j) {
        // Base Cases
        if (i < 0 && j < 0)
            return true;
        if (i < 0 && j >= 0)
            return false;
        if (j < 0 && i >= 0)
            return isAllStars(S1, i);

        /* If the characters at the current
        positions match or S1 has a '?' */
        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?') {
            return wildcardMatchingUtil(S1, S2, i - 1, j - 1);
        }
        /* Two options: either '*' represents an
        empty string or it matches a character in S2 */
        if (S1.charAt(i) == '*') {
            return wildcardMatchingUtil(S1, S2, i - 1, j) || wildcardMatchingUtil(S1, S2, i, j - 1);
        }
        return false;
    }

}
