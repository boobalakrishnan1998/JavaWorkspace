package com.myproject.code.dynamicprogramming;

public class MinimumInsertionsDeletionToConvertAtoB {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "anc";
        char[] lcs = funcTab(str1.toCharArray(), str2.toCharArray());
        int n = str1.length();
        int m = str2.length();
        System.out.println(n + m - (2 * lcs.length));
    }

    private static char[] funcTab(char[] str1, char[] str2) {
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
        int ansLen = dp[n][m];
        char[] ans = new char[ansLen];
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (str1[i - 1] == str2[j - 1]) {
                ans[--ansLen] = str1[i - 1];
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return ans;
    }
}
