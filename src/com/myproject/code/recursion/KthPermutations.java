package com.myproject.code.recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermutations {
    public static void main(String[] args) {
        int n = 4, k = 17;
        String ans = findKthPermuatation(n, k);
        System.out.println("The Kth permutation sequence is " + ans);
    }

    //Todo Understand this code
    private static String findKthPermuatation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k - 1;
        String ans = "";
        while (true) {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.isEmpty()) {
                break;
            }
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
}
