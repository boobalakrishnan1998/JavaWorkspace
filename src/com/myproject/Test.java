package com.myproject;

import java.util.Arrays;
import java.util.Scanner;

// Java program to print a new line in string
class Test {
    // Main Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First string");
        String str1 = sc.nextLine();
        System.out.println("Enter the second string");
        String str2 = sc.nextLine();

        str1 = str1.replace(str2, "");
        System.out.println("Final String " + str1);
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for (int i = 0; i < ch2.length; i++) {
            for (int j = 0; j < ch1.length; j++) {
                if (ch1[j] == ch2[i]) {
                    ch1[j] = '0';
                }
            }
        }
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != '0') {
                System.out.print(ch1[i]);
            }
        }
    }

    private static Integer[] NormalSortedArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int temp;
                if (array[i] > array[j]) {
                    array[i] = array[i] + array[j];
                    array[j] = array[i] - array[j];
                    array[i] = array[i] - array[j];
                    /*temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;*/
                }
            }
        }
        return array;
    }


}
