package com.myproject.code.dynamicprogramming;

import java.util.Stack;

public class MaximumRectangleAreaWithAll1 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

    /* Function call to find the largest
    rectangle area containing all 1s */
        int ans =
                maximalAreaOfSubMatrixOfAll1(matrix);
        System.out.println("The largest rectangle area containing all 1s is: " + ans);
    }

    static int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {

        // Determine the size of matrix
        int n = matrix.length;
        int m = matrix[0].length;

        // Write your code here.
        int maxArea = 0;
        int[] height = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) height[j]++;
                else height[j] = 0;
            }
            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    static int largestRectangleArea(int[] histo) {
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        int n = histo.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
                int height = histo[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }

}
