package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class DistinctSubsequences {
    private static final int prime = (int) (1e9 + 7);

    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        System.out.println("The Count of Distinct Subsequences is " + distinctSubsequences(s1, s2));
    }

    public static int distinctSubsequences(String s, String t) {
        int lt = s.length();
        int ls = t.length();
        int[][] dp = new int[lt][ls];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countUtil(s, t, lt - 1, ls - 1);
    }

    public int distinctSubsequencesSpaceOp(String s, String t) {
        int n = s.length();
        int m = t.length();
        /* Declare an array to store the count of
        distinct subsequences for each character in t*/
        int[] prev = new int[m + 1];
        // Initialize the count for an empty string
        prev[0] = 1;
        // Iterate through s and t to calculate counts
        for (int i = 1; i <= n; i++) {
            /* Iterate in reverse direction to
            avoid overwriting values prematurely*/
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    /* If the characters match, consider two options:
                    either leave one character in s and t or leave
                    one character in s and continue matching t*/
                    prev[j] = (prev[j - 1] + prev[j]) % prime;
                }
                /* No need for an else statement since we
                can simply leave the previous count as is*/
            }
        }
        /* The value at prev[m] contains
        the count of distinct subsequences*/
        return prev[m];
    }

    public int distinctSubsequencesMem(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        /* Initialize the first row: empty string t can
        be matched with any non-empty s in one way*/
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        /* Initialize the first column:
        s can't match any non-empty t*/
        for (int i = 1; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill in the DP array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    /* If the characters match, consider two options:
                    either leave one character in s and t or leave
                    one character in s and continue matching t*/
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % prime;
                } else {
                    /* If the characters don't match, we can
                    only leave the current character in s*/
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        /* The value at dp[n][m] contains
        the count of distinct subsequences*/
        return dp[n][m];
    }

    private int countUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        /* If s2 has been completely matched,
        return 1 (found a valid subsequence)*/
        if (ind2 < 0)
            return 1;

        /* If s1 has been completely traversed
        but s2 hasn't, return 0*/
        if (ind1 < 0)
            return 0;

        /* If the result for this state has
        already been calculated, return it*/
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        int result = 0;

        /* If the characters match, consider two options:
        either leave one character in s1 and s2 or leave
        one character in s1 and continue matching s2*/
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            int leaveOne = countUtil(s1, s2, ind1 - 1, ind2 - 1, dp);
            int stay = countUtil(s1, s2, ind1 - 1, ind2, dp);

            result = (leaveOne + stay) % prime;
        } else {
            /* If characters don't match, just leave
            one character in s1 and continue matching s2*/
            result = countUtil(s1, s2, ind1 - 1, ind2, dp);
        }
        // Store the result and return it
        dp[ind1][ind2] = result;
        return result;
    }

    private static int countUtil(String s1, String s2, int ind1, int ind2) {
        /* If s2 has been completely matched,
        return 1 (found a valid subsequence)*/
        if (ind2 < 0)
            return 1;

        /* If s1 has been completely traversed
        but s2 hasn't, return 0*/
        if (ind1 < 0)
            return 0;

        int result = 0;

        /* If the characters match, consider two options:
        either leave one character in s1 and s2 or leave
        one character in s1 and continue matching s2*/
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            int leaveOne = countUtil(s1, s2, ind1 - 1, ind2 - 1);
            int stay = countUtil(s1, s2, ind1 - 1, ind2);

            result = (leaveOne + stay) % prime;
        } else {
            /* If characters don't match, just leave
            one character in s1 and continue matching s2*/
            result = countUtil(s1, s2, ind1 - 1, ind2);
        }
        // Return the result
        return result;
    }
}
