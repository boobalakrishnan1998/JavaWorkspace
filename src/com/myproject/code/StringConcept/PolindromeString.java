package com.myproject.code.StringConcept;

import java.util.Locale;
import java.util.Scanner;

public class PolindromeString {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner=new Scanner(System.in);
       // String inputStr=scanner.nextLine();
        String inputStr="";
        checkpolindromeNormal(inputStr);
        //Two pointer methods
        checkpolindromeTwoPointer(inputStr);
    }

    private static void checkpolindromeTwoPointer(String inputStr) {
        inputStr=inputStr.toLowerCase();
        if(inputStr.isEmpty()){
            throw new NullPointerException("Input string must not be empty");
        }
        int inputStrLen= inputStr.length();
        for(int i=0;i<inputStrLen/2;i++){
            if(inputStr.charAt(i)!= inputStr.charAt((inputStrLen-i)-1)){
                System.out.println("Given Input "+ inputStr +" is Not a polindrome");
                return;
            }
        }
        System.out.println("Given Input "+ inputStr +" is a polindrome");
    }

    private static String checkpolindromeNormal(String inputStr) {
        String reverseStr="";
        for(int i = inputStr.length()-1; i>=0; i--){
            reverseStr+= inputStr.charAt(i);
        }
        if(inputStr.equalsIgnoreCase(reverseStr))
            System.out.println("Given Input "+inputStr+" is polindrome");
        else
            System.out.println("Given Input "+inputStr+" is Not a polindrome");

        return reverseStr;
    }
}
