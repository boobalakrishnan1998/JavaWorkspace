package com.myproject.code.arrayConcept;

import java.util.HashMap;
import java.util.Map;

public class FindPairWithGivenSum {

    public static void main(String[] args) {
        int n = 5, x = 4;
        int[] arr = {1,2, 5, 6, 7};
        System.out.println(findPair(arr, x));
    }

    private static boolean findPair(int[] arr, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int a : arr) {
            if (map.containsKey(x - a)) {
                return true;
            }
            map.put(a, i++);
        }
        return false;
    }
}
