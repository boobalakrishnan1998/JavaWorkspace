package com.myproject.code.arrayConcept;

import java.util.Arrays;

public class ArrayRotateByK {
/*  123456
    654321
    564321
    561234 */

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 9, 22, 33, 44, 55, 66, 77, 88, 99, 100};
        int key = 5;
        Arrays.stream(rotateArrayByOne(array, key)).forEach(System.out::println);
        Arrays.stream(leftRotate(array, array.length, key)).forEach(System.out::println);
    }

    public static int[] rotateArrayByOne(int[] array, int key) {

        int n = array.length;
        for (int i = 0, j = n - 1; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[j - i];
            array[j - i] = temp;
        }

        for (int i = 0, j = key - 1; i < key / 2; i++) {
            int temp = array[i];
            array[i] = array[j - i];
            array[j - i] = temp;
        }
        // 564321
        for (int i = key, j = n - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return array;
    }
    static int[] leftRotate(int arr[], int n, int d) {

        // Get the effective number of rotations: if more the length
        d = d % n;

        //step 1:
        reverse(arr, 0, d - 1);

        //step 2:
        reverse(arr, d, n - 1);

        //step 3:
        reverse(arr, 0, n - 1);
        return arr;
    }
    static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
