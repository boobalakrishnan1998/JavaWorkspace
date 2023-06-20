package com.myproject.code.NumberConcept;


public class SwapNumbers {

    public static void main(String[] args) {

        int a=10;
        int b=20;
        int c=30;
        SwapTwoNumber(a,b);
        SwapThreeNumber(a,b,c);
    }

    private static void SwapTwoNumber(int a, int b) {
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("a :"+a+" b :"+b );
    }
    private static void SwapThreeNumber(int a, int b,int c) {
        a=a+b+c;
        b=a-(b+c);
        c=a-(b+c);
        a=a-(b+c);
        System.out.println("a :"+a+" b :"+b+" c :"+c );
    }


}
