package com.myproject.code.arrayConcept;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the key");
        String strKey=sc.nextLine();
        String[] strArr=new String[]{"Boobalan","Kannan","Deva","Udhai","Thiru"};

        for(int i=0;i<strArr.length;i++){

            if(strArr[i].equalsIgnoreCase(strKey)){
                System.out.println("Element found at index :"+i);
                return;
            }
        }
        System.out.println("Element not found in array");
    }







}
