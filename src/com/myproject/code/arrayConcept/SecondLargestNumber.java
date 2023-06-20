package com.myproject.code.arrayConcept;

public class SecondLargestNumber {
    public static void main(String[] args) {
        int[] intArray = new int[]{72, 34, 46, 18, 10, 12, 142, 116, 18};
        int highest = 0;
        int secondLargest = 0;
        for (int i : intArray) {
            if (i > highest) {
                secondLargest = highest;
                highest = i;
            } else if (i > secondLargest) {
                secondLargest = i;
            }
        }
        System.out.println("The secound largest Number is "+secondLargest);
    }


}
