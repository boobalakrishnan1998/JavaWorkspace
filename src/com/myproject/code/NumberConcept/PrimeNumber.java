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
        //method1(number, count);
        // method2(number);
        //print n prime number
        for(int i=1;number>count;i++){
            int curNum=0;
            int temp=i;
            for(int j = 2; j <= temp; j++){
                if(temp % j ==0){
                    curNum= j;
                    break;
                }
            }
            if(temp ==curNum){
                System.out.print(temp+" ");
                count++;
            }
        }
    }

    private static void method2(int number) {
        int curNum=0;
        for(int i = 2; i<= number; i++){

            if(number %i==0){
                curNum=i;
                break;
            }
        }
        if(number ==curNum){
            System.out.println("Given number is Prime number ");
        }else{
           System.out.println("Given number is not a prime number ");
        }
    }

    private static void method1(int number, int count) {
        for (int i = 1; i<= number; i++){
           if(number %i==0){
               count++;
           }
        }
        if(count ==2){
            System.out.println("Given number is Prime number ");
        }else{
            System.out.println("Given number is not a prime number ");
        }
    }


    public void lessTimeComplex() {

        int num = 29;
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
