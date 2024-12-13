package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String str1 = "bdefg";
        String str2 = "bfg";
        String ans = longestComSub(str1, str2);
        System.out.println(ans);
    }

    private static String longestComSub(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return funcTab(str1.toCharArray(), str2.toCharArray());
    }

    private static String funcTab(char[] str1, char[] str2) {
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
        // Reconstruct the shortest supersequence from DP table
        int len = dp[n][m];
        int i = n;
        int j = m;

        int index = len - 1;
        StringBuilder ans = new StringBuilder();

        // Build the shortest supersequence by backtracking
        while (i > 0 && j > 0) {
            if (str1[i - 1] == str2[j - 1]) {
                ans.append(str1[i - 1]);
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(str1[i - 1]);
                i--;
            } else {
                ans.append(str2[j - 1]);
                j--;
            }
        }

        // Add remaining characters from str1 or str2
        while (i > 0) {
            ans.append(str1[i - 1]);
            i--;
        }
        while (j > 0) {
            ans.append(str2[j - 1]);
            j--;
        }
        // Reverse the result since we built it backwards
        ans.reverse();
        return ans.toString();
    }
}
