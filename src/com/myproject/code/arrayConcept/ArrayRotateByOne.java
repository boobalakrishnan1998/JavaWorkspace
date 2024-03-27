package com.myproject.code.arrayConcept;

import java.util.Arrays;

public class ArrayRotateByOne {
    public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6};
    Arrays.stream(rotateArrayByOne(array)).forEach(System.out::print);
   }
    public static int[] rotateArrayByOne(int[] array){
        int i=0, j =array.length-1;
        while(i!=j){
            int temp=array[i];
            array[i]=array[j];
            array[j]=temp;
            i++;
        }
        return array;
    }
}
