package com.myproject.code.arrayConcept;

import java.util.Arrays;

public class findPeakElementInMatrix_II {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(Arrays.toString(findPeakElement(matrix)));

    }

    public static int[] findPeakElement(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxRow = findMaxRow(matrix, n, mid);
            int left = mid - 1 >= 0 ? matrix[maxRow][mid - 1] : -1;
            int right = mid + 1 <m ? matrix[maxRow][mid + 1] : -1;
            if (matrix[maxRow][mid] > left && matrix[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            } else if (matrix[maxRow][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }


        }
        return new int[]{-1, -1};
    }

    private static int findMaxRow(int[][] matrix, int n, int col) {
        int maxValue = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] > maxValue) {
                maxValue = matrix[i][col];
                index = i;
            }
        }
        return index;
    }
}
