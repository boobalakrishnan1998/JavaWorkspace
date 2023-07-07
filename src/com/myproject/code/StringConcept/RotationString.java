package com.myproject.code.StringConcept;

import java.util.Scanner;

public class RotationString {
    public static void main(String[] args) throws Exception {
        //String 1: abcde
        //String 2 : deabc
        Scanner scar = new Scanner(System.in);
        System.out.println("Please enter original String");
        String input = scar.nextLine();
        System.out.println("Please enter rotation of String");
        String rotation = scar.nextLine();
        if (checkRotation(input, rotation)) {
            System.out.println(input + " and " + rotation + " are rotation of each other");
        } else {
            System.out.println("Sorry, they are not rotation of another");
        }
        scar.close();
    }

    /**
     * This method check is given strings are rotation of each other * @param original * @param rotation * @return true or false
     */
    public static boolean checkRotation(String original, String rotation) {
        if (original.length() != rotation.length()) {
            return false;
        }
        String concatenated = original + original;
        if (concatenated.indexOf(rotation) != -1) {
            return true;
        }
        return false;
    }
}

