package com.myproject.code.arrayConcept;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortingArray {

    public static void main(String[] args) {
      /*  Integer[] array = new Integer[]{12, 10, 17, -1, 24, 03, -90};
        if (array.length == 0) {
            throw new NullPointerException("Array is must not be empty");
        }*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int arrayLen = sc.nextInt();
        if (arrayLen <= 0) {
            System.out.println("Please Enter the valid number");
            return;
        }
        Integer[] array = new Integer[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            array[i] = sc.nextInt();
        }

        sortArrayNormal(array);
        sortArrayJava8(array);
    }
    private static void sortArrayJava8(Integer[] arrayInt) {
        Arrays.stream(arrayInt).sorted(Integer::compareTo).forEach(System.out::println);
        Arrays.sort(arrayInt);
        Arrays.sort(arrayInt, Collections.reverseOrder());
        Arrays.sort(arrayInt,2,5);
    }

    private static void sortArrayNormal(Integer[] arrayInt) {
        for(int i = 0; i< arrayInt.length; i++){
            for(int j = i+1; j< arrayInt.length; j++){
                if(arrayInt[i]> arrayInt[j]) {
                    int temp;
                    temp = arrayInt[i];
                    arrayInt[i] = arrayInt[j];
                    arrayInt[j] = temp;
                }
            }
        }
        System.out.println("Sorted array element :: ");
        Arrays.stream(arrayInt).forEach(System.out::println);
    }
}
