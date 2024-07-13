package com.myproject.code.arrayConcept;

public class MaxRowMatrixWith1s {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}};
        int maxRow = findMaxRowWith1s(matrix);
        System.out.println(maxRow);
    }

    private static int findMaxRowWith1s(int[][] matrix) {

        int maxRow = 0;
        int index = -1;
        for (int i = 0; i < matrix.length; i++) {
            int curMaxRow = matrix[i].length - lowerBound(matrix[i], matrix[i].length, 1);
            if (curMaxRow > maxRow) {
                maxRow = curMaxRow;
                index = i;
            }
        }
        return index;

    }

    private static int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {            // maybe an answer
                ans = mid;
                high = mid - 1;//look for smaller index on the left
            } else {
                low = mid + 1;// look on the right
            }
        }
        return ans;
    }
}
