package com.myproject.code.greedy;

import java.util.Arrays;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String s = "(*))";

        boolean ans = isValid(s);

        if (ans)
            System.out.println("The given string is valid.");
        else
            System.out.println("The given string is not valid.");
    }

    public static boolean isValid(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++; // Treat as opening
                maxOpen++; // Treat as opening
            } else if (c == ')') {
                minOpen--; // Treat as closing
                maxOpen--; // Treat as closing
            } else if (c == '*') {
                minOpen--; // Treat as closing
                maxOpen++; // Treat as opening
            }
            if (maxOpen < 0) return false; // More closing parentheses than opening
            if (minOpen < 0) minOpen = 0; // Reset minOpen if negative
        }
        return minOpen == 0; // Check if balanced
    }

    public static boolean isValidBF(String s) {
        int n = s.length();

        // DP table
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return checkValid(0, 0, s, dp);
    }

    private static boolean checkValid(int ind, int count, String s, int[][] dp) {
        // Base case
        if (count < 0) return false;
        // Base case
        if (ind == s.length()) {
            return (count == 0);
        }

        // If already computed, return the value directly
        if (dp[ind][count] != -1) return dp[ind][count] == 1;

        boolean ans = false;

        // If the current index has '('
        if (s.charAt(ind) == '(')
            ans = checkValid(ind + 1, count + 1, s, dp);
            // If the current index has ')'
        else if (s.charAt(ind) == ')')
            ans = checkValid(ind + 1, count - 1, s, dp);

            // else if the current index has '*'
        else {
            for (int i = -1; i <= 1; i++) {
                ans = ans || checkValid(ind + 1, count + i, s, dp);
            }
        }

        // Store the value in DP and return the value
        dp[ind][count] = ans ? 1 : 0;
        return ans;
    }
}
