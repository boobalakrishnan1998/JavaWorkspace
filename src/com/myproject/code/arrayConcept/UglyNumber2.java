package com.myproject.code.arrayConcept;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber2 {
    public static void main(String[] args) {
        int n = 10;
        int ans = findNthUglyNumber(n);
        System.out.println(ans);

    }
    private static int findNthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int twoMultiple = list.get(p2) * 2;
            int threeMultiple = list.get(p3) * 3;
            int fiveMultiple = list.get(p5) * 5;
            int minMultiple = Math.min(twoMultiple, Math.min(threeMultiple, fiveMultiple));
            list.add(minMultiple);
            if (minMultiple == twoMultiple) p2++;
            if (minMultiple == threeMultiple) p3++;
            if (minMultiple == fiveMultiple) p5++;
        }
        return list.get(list.size()-1);
    }
}
