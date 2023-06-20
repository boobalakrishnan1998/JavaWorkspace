package com.myproject.code.arrayConcept;

public class BinarySearch {

    public static void main(String[] args) {
                                      // 0,1,2,3,4,5 ,6, 7, 8 ,9 ,10
        Integer[] intArray=new Integer[]{1,4,5,6,7,43,50,60,70,99,100};
        int low = 0;
        int high = intArray.length - 1;
        int mid = (low + high) / 2;
        int key = 9;
        while (low <= high) {
            if (intArray[mid] == key) {
                System.out.println("The key " + key + " found at index " + mid);
                break;
            } else if (intArray[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        if (low >high) {
            System.out.println("The key " + key + " Not found in Array ");
        }
    }


}
