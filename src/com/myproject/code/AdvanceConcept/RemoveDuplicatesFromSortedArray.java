package com.myproject.code.AdvanceConcept;

public class RemoveDuplicatesFromSortedArray {
     public static void main(String[] args) {
            int[] intArr = new int[]{0, 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 7, 8, 9};
            /*int j = 1;
            for (int i = 1; i < intArr.length; i++) {
                   if(intArr[i]!=intArr[i-1]){
                          intArr[j]=intArr[i];
                          j++;
                   }
            }*/
            int duplicateCount = 0;
            for (int i = 1; i < intArr.length; i++) {
                   if (intArr[i] == intArr[i - 1]) {
                          duplicateCount = duplicateCount + 1;
                   } else {
                          intArr[i - duplicateCount] = intArr[i];
                   }
            }
            for (int i = 0; i < intArr.length - duplicateCount; i++) {
                System.out.print(intArr[i]+" ");

            }
     }
}
