package com.myproject.code.arrayConcept;

public class FindMissingNumber {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6};
        System.out.println(findMissingNumber(array));
    }

    private static int findMissingNumber(int[] array) {
        int n = array.length + 1;
        int sum = 0;
        for (int a : array) {
            sum += a;
        }
        return (n * (n + 1) / 2) - sum;
    }


}
