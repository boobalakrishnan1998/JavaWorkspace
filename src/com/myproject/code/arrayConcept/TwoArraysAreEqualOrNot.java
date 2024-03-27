package com.myproject.code.arrayConcept;

import java.util.HashMap;
import java.util.Map;

public class TwoArraysAreEqualOrNot {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6};
        int[] array2 = {1, 2, 3, 4, 6};

        System.out.println(isArrayEqual(array, array2));
    }

    private static boolean isArrayEqual(int[] array, int[] array2) {
        Map<Integer, Integer> map = new HashMap<>();
        if (array.length != array2.length) {
            return false;
        }
        for (int j : array) {
            int count = map.getOrDefault(j, 0);
            map.put(j, ++count);
        }
        for (int j : array2) {
            int count = map.getOrDefault(j, 0);
            if (count == 0) {
                return false;
            }
            map.put(j, --count);
        }
        return true;
    }
}
