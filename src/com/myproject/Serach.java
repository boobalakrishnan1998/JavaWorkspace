package com.myproject;

import java.util.Scanner;
import java.util.function.Function;

public class Serach {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Element to search");
        Integer key= sc.nextInt();
                                    // 0,1,2,3,4,5 ,6, 7, 8 ,9 ,10
        Integer[] arrInt=new Integer[]{1,4,5,6,7,43,50,60,70,99,100};
        int low=0;
        int high=arrInt.length-1;
        int mid=(low+high)/2;

        while (low<=high){
            if(arrInt[mid]==key){
                System.out.println("Element "+key+" found in Index "+mid);
                break;
            }else if(arrInt[mid]>key){
                high=mid-1;
            }else {
                low=mid+1;
            }
            mid=(low+high)/2;
        }
        if(high<low){
            System.out.println("Element not found in array");
        }
    }







}
