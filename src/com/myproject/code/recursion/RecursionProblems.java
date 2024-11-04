package com.myproject.code.recursion;

import java.util.Arrays;

public class RecursionProblems {

    public static void main(String[] args) {
        //printName(5);
        int sum = countNumberFunctional(5);
        countNumber(5, 0);
        System.out.println(sum);
        System.out.println(factorial(5));
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(palindrome("MADAM", 0));
        System.out.println(fibonacci(10));

    }

    private static void printName(int n) {
        if (n < 1)
            return;
        System.out.println("BK");
        n--;
        printName(n);
    }

    private static void countNumber(int n, int sum) {
        if (n < 1) {
            System.out.println(sum);
            return;
        }
        sum = sum + n;
        n--;
        countNumber(n, sum);
    }

    private static int countNumberFunctional(int n) {
        if (n == 0)
            return 0;
        return n + countNumberFunctional(n - 1);
    }

    private static int factorial(int n) {
        if (n == 1)
            return 1;
        return n * countNumberFunctional(n - 1);
    }

    private static void reverse(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        reverse(arr, l + 1, r - 1);
    }

    private static boolean palindrome(String str, int i) {
        if (i > str.length() / 2) {
            return true;
        }
        if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
            return false;
        }
        return palindrome(str, i + 1);
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
