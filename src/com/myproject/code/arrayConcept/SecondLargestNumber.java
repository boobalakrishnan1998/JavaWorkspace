package com.myproject.code.arrayConcept;

public class SecondLargestNumber {
    public static int main() {
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
        return secondLargest;
//        System.out.println("The second largest Number is "+secondLargest);
    }


}
