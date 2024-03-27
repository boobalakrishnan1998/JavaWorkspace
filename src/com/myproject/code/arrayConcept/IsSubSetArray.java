package com.myproject.code.arrayConcept;

import java.util.HashMap;
import java.util.Map;

public class IsSubSetArray {

    public static void main(String[] args) {
       int[] a1 = {11, 7, 1, 13, 21, 3, 7, 3};
      int[] a2 = {11, 3, 7, 1, 7};

        System.out.println(isArrayEqual(a1, a2));
    }

    private static boolean isArrayEqual(int[] array, int[] array2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : array) {
            int count = map.getOrDefault(j, 0);
            map.put(j, count+1);
        }
        for (int j : array2) {
            int count = map.getOrDefault(j, 0);
            if(count==0){
                return false;
            }
            map.put(j, count-1);
        }
        return true;
    }
}
