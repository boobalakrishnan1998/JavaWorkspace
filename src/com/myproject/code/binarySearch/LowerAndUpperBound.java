package com.myproject.code.binarySearch;

public class LowerAndUpperBound {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int n = 5, x = 9;
        int lowerBound = lowerBound(arr, n, x);
        System.out.println("The lower bound is the index: " + lowerBound);
        int upperBound = upperBound(arr, n, x);
        System.out.println("The upper bound is the index: " + upperBound);
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

    private static int upperBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {// maybe an answer
                ans = mid;
                high = mid - 1;//look for smaller index on the left
            } else {
                low = mid + 1;// look on the right
            }
        }
        return ans;
    }
}
