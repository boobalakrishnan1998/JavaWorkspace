package com.myproject.code.NumberConcept;

import java.io.InputStream;
import java.util.Scanner;

public class Polindrome {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Number :");
        int number=sc.nextInt();
        int rev=0;
        int rem;
        int number1=number;

        if(number<=0){
            System.out.println("Please enter the valid number ");
            return;
        }
        while(number>0){
            rem=number%10;
            rev=rev*10+rem;
            number=number/10;
        }
        if(rev==number1){
            System.out.println("given number is palindrome:");
        }else{
            System.out.println("given number is not a palindrome:");
        }
    }
}
