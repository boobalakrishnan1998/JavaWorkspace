package com.myproject.code.arrayConcept;

import java.util.Arrays;

public class FindMissingAndRepeatingNumber {

    public static void main(String[] args) {
        int[] array = {4, 3, 6, 2, 1, 1};
        System.out.println(Arrays.toString(findMissingAndRepeatingNumber(array)));
    }

    private static int[] findMissingAndRepeatingNumber(int[] array) {
        int n = array.length;
        int sumN = n * (n + 1) / 2;
        int sum2N = n * (n + 1) * (2 * (n + 1)) / 6;
        int sum = 0;
        int sum2 = 0;
        for (int a : array) {
            sum += a;
            sum2 += a * a;
        }
        int val1 = sum - sumN; // x - y
        int val2 = sum2 - sum2N; // x2 - y2 = (x-y) (x+y) =val2
        val2 = val2 / val1; // x + y
        int x = (val1 + val2) / 2;
        int y = x - val1;
        return new int[]{x, y};
    }

/*  x-y = val1
    x2-y2 = val2
    (x-y) (x+y) = val2
    val1 (x+y) = val2
    (x+y) = val2 / val1
    x-y=val1
    x+y=val2
---------------
   2x=val1+val2
   x=val1+val2
   y=x-val1
*/
}
