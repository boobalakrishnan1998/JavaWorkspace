package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String str1 = "bdefg";
        String str2 = "bfg";
        int ans = longestComSub(str1, str2);
        System.out.println(ans);
    }

    private static int longestComSub(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return funcSpaceOp(str1.toCharArray(), str2.toCharArray());
    }

    private static int funcSpaceOp(char[] str1, char[] str2) {
        int n = str1.length;
        int m = str2.length;
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        // Initialize the base cases
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (str1[ind1 - 1] == str2[ind2 - 1]) {
                    cur[ind2] = 1 + prev[ind2 - 1];
                } else {
                    cur[ind2] = Math.max(prev[ind2 - 1], prev[ind2]);
                }
            }
            prev = cur;
        }
        return prev[m];
    }

    private static int funcTab(char[] str1, char[] str2) {
        int n = str1.length;
        int m = str2.length;
        int[][] dp = new int[n + 1][m + 1];
        // Initialize the base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (str1[ind1 - 1] == str2[ind2 - 1]) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1][ind2 - 1], dp[ind1 - 1][ind2]);
                }
            }
        }
        return dp[n][m];
    }

    private static int funcDp(char[] str1, char[] str2, int ind1, int ind2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }
        if (str1[ind1] == str2[ind2]) {
            return dp[ind1][ind2] = 1 + func(str1, str2, ind1 - 1, ind2 - 1);
        } else {
            return dp[ind1][ind2] = Math.max(func(str1, str2, ind1, ind2 - 1), func(str1, str2, ind1 - 1, ind2));
        }
    }

    private static int func(char[] str1, char[] str2, int ind1, int ind2) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if (str1[ind1] == str2[ind2]) {
            return 1 + func(str1, str2, ind1 - 1, ind2 - 1);
        } else {
            return Math.max(func(str1, str2, ind1, ind2 - 1), func(str1, str2, ind1 - 1, ind2));
        }
    }
}
