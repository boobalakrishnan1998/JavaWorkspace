package com.myproject.code.arrayConcept;

public class Sort0and1 {

    public static void main(String[] args) {
        sort0and1Array();
    }

    public static void sort0and1Array() {
        //int[] arr=new int[]{0,1,0,0,1,1,1,0,1,0,1};
        int[] inputArray = new int[]{0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1};
        int left = 0;
        int right = inputArray.length - 1;
        while (left < right) {
            if (inputArray[left] == 1) {
                //Swapping
                inputArray[right] = inputArray[right] + inputArray[left];
                inputArray[left] = inputArray[right] - inputArray[left];
                inputArray[right] = inputArray[right] - inputArray[left];
                right--;
            } else {
                left++;
            }
        }
    }

}
