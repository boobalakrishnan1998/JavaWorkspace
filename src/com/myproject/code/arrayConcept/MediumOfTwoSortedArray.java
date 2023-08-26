package com.myproject.code.arrayConcept;

public class MediumOfTwoSortedArray {

    public static void main(String[] args) {
        int[] nums1 =new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(getMeddle(nums1,nums2));
    }
    public static double getMeddle(int arr1[],int arr2[]){

        int i=0,j=0,k=0;
        int totLen=arr1.length+arr2.length;
        int[] sum=new int[totLen];
           while(k<totLen){
              if(i<arr1.length&&j<arr2.length){
                 if(arr1[i]<arr2[j]){
                     sum[k++]=arr1[i++];
                 }else{
                     sum[k++]=arr2[j++];
                 }
              }else if(i<arr1.length){
                  sum[k++]=arr1[i++];
              }else{
                  sum[k++]=arr2[j++];
              }
           }
        return totLen%2==0? (double) (sum[totLen / 2] + sum[(totLen - 1) / 2]) /2:sum[totLen/2];
    }




}
