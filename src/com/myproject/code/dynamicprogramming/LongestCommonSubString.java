package com.myproject.code.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String str1 = "bdefgk";
        String str2 = "bfgk";
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
        return funcTab(str1.toCharArray(), str2.toCharArray());
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
        int ans = 0;
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (str1[ind1 - 1] == str2[ind2 - 1]) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    ans = Math.max(ans, dp[ind1][ind2]);
                } else {
                    dp[ind1][ind2] = 0;
                }
            }
        }
        return ans;
    }
}
