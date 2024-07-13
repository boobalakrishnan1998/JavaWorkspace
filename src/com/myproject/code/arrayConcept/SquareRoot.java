package com.myproject.code.arrayConcept;

public class SquareRoot {
    public static void main(String[] args) {
        long x = 5;
        System.out.println(findSquareRoot(x));
    }

    private static long findSquareRoot(long x) {
        long squareRoot = 1;
        int low = 0;
        int high = (int) (x - 1);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (((long) mid * mid) <= x) {
                squareRoot = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return squareRoot;
    }
}
