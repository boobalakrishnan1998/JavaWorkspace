package com.myproject.code.NumberConcept;


import java.util.Scanner;

// 0 1 1 2 3  5 8 13 21 34 55
public class Fibonacci {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number");
        int number=sc.nextInt();
        int first=0, second =1,next;
        for(int i=0;i<=number;i++){
          System.out.print(first+" ");
            next=first+ second;
            first= second;
            second =next;
        }
    }
}
