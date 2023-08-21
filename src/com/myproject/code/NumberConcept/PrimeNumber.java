package com.myproject.code.NumberConcept;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number to check");
        int number=sc.nextInt();
        int count=0;
        if(number==0||number==1){
            System.out.println("Not a prime number");
            return;
        }
        lessTimeComplex(number);
    }
    public static void lessTimeComplex(int num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
    }
}
