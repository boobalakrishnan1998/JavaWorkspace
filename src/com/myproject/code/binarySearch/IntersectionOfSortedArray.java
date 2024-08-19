package com.myproject.code.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArray {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {3, 4, 5, 6, 7};
        System.out.println(findIntersection(a, b));
    }

    private static List<Integer> findIntersection(int[] a, int[] b) {
        int an = a.length;
        int bn = b.length;
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < an && j < bn) {
            if (a[i] == b[j]) {
                // return unique Array
                /*if(!((i!=0 && j!=0) && a[i] == a[i-1] && b[j] == b[j-1])) {

                }*/
                list.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            }else{
                j++;
            }
        }
        return list;
    }
}
