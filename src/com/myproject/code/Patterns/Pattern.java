package com.myproject.code.Patterns;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
      /*  Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number");
        int number=sc.nextInt();
*/
        int number=5;
        pattern5(number);

    }
       /*
        * * * * *
        * * * * *
        * * * * *
        * * * * *
        * * * * *
        */
    private static void pattern1(int number) {
        for(int row = 1; row<= number; row++){
            for(int col = 1; col<= number; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
     *
     * *
     * * *
     * * * *
     * * * * *
     */
    private static void pattern2(int number) {
        for(int row = 1; row<= number; row++){
            for(int col = 1; col<= row; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
     * * * * *
     * * * *
     * * *
     * *
     *
     */
    private static void pattern3(int number) {
        for(int row = 1; row<= number; row++){
          /*  for(int col = number; col>=row; col--){
                System.out.print("* ");
            }*/
          /*  for(int col = 1; col<=(number+1)-row; col++){
                System.out.print("* ");
            }*/
            for(int col = row; col<=number; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    /*
     *
     * *
     * * *
     * * * *
     * * * * *
     * * * *
     * * *
     * *
     *
     */
    private static void pattern4(int number) {
       // method1(number);
        //method2(number);
        for(int row=1;row<=(2*number-1);row++){
            int totalCol=row>number?(2*number-row): row;
            for(int col=1;col<=totalCol;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void method2(int number) {
        for(int row = 1; row<=(number *2)-1; row++){
           if(row< number){
               for(int col=1;col<=row;col++){
                   System.out.print("* ");
               }
           }else{
               for(int col = row; col<=(number *2)-1; col++){
                   System.out.print("* ");
               }
           }
            System.out.println();
        }
    }

    private static void method1(int number) {
        for(int row = 1; row< number; row++){
            for(int col=1;col<=row;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int row = 1; row<= number; row++){
            for(int col = row; col<= number; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern5(int number) {

        for(int row=1;row<=(2*number-1);row++){
            int totalcol=row>number?row-number:(number-row);
            for(int col=1;col<=totalcol;col++){
                System.out.print(" ");
            }
            int totalCol=row>number?(2*number-row): row;
            for(int col=1;col<=totalCol;col++){
                System.out.print("* ");
            }
            System.out.println();
        }

        /*for(int row=1;row<=(2*number)-1;row++){
            int totalcol=row>number?row-number:(number-row);
            for(int col=1;col<=totalcol;col++){
                System.out.print("  ");
            }

            int totalstartcol=row>number?row-number:row;
            for(int col=1;col<=(totalstartcol*2)-1;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
*/    }













}
