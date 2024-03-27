package com.myproject.code.arrayConcept;

import java.util.Arrays;

public class Sort_0_1_2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort0_1_2Array()));
    }

    public static int[] sort0_1_2Array() {
        //int[] arr=new int[]{0, 1, 0, 0, 2, 0, 2, 1, 1, 1, 2, 1, 2, 0, 2, 1, 0, 1};
        int[] array = new int[]{0, 1, 0, 0, 2, 0, 2, 1, 1, 1, 2, 1, 2, 0, 2, 1, 0, 1};
        int low = 0;
        int mid = 0;
        int high = array.length - 1;
        while (mid <= high) {
            if(array[mid]==0){
                int temp=array[low];
                array[low]=array[mid];
                array[mid]=temp;
                low++;
                mid++;
            }else if(array[mid]==1){
                mid++;
            }else{
                int temp=array[high];
                array[high]=array[mid];
                array[mid]=temp;
                high--;
            }
        }
        return array;
    }
}
