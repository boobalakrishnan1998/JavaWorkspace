package com.myproject.code.NumberConcept;

import java.util.Scanner;

public class Factorial {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int number=sc.nextInt();

        for(int i=1;i<=number;i++){
            int fact = methodRecusion(i);
            System.out.print(" "+fact);
        }
        /*int fact = methodRecusion(number);
        System.out.println(fact);*/

    }

    private static int method1(int number) {
        int fact=1;
        if(number==0)
            return 0;
        for(int i = 1; i<= number; i++){
          fact=fact*i;
        }
        return fact;
    }


    private static int methodRecusion(int number) {
         if(number==0)
             return 1;
        return number * methodRecusion((number-1));
    }
}
