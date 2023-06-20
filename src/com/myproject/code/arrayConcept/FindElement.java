package com.myproject.code.arrayConcept;

import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        //String inputStr=sc.nextLine();
       //String keystr=sc.nextLine();
        String inputStr="hi how are you".toLowerCase();
        String keystr="t";
        findElementNormal(inputStr, keystr);

        findElementTwoPointer(inputStr, keystr);


    }

    private static void findElementTwoPointer(String inputStr, String keystr) {
        char[] strChar= inputStr.toCharArray();
        int strLength= inputStr.length();
        boolean found=false;
        for(int i=0;i<strLength/2;i++){
            if(keystr.equalsIgnoreCase(String.valueOf(strChar[i]))){
                System.out.println("the element ::"+ keystr +" find at index "+i);
                found=true;
            }else if(keystr.equalsIgnoreCase(String.valueOf(strChar[(strLength-i)-1]))){
                System.out.println("the second part element ::"+ keystr +" find at index "+((strLength-i)-1));
                found=true;
            }
        }
        if(found){
            System.out.println("the element :: "+ keystr +" found");
        }else{
            System.out.println("the element :: "+ keystr +" Not found");
        }
    }

    private static void findElementNormal(String inputStr, String keystr) {
        String[] ArrayStr= inputStr.split(" ");
        for(int i=0;i<ArrayStr.length;i++){
             if(keystr.equalsIgnoreCase(ArrayStr[i])){
                 System.out.println("the element ::"+ keystr +" find at index "+i);
                 break;
             }
        }
    }


}
