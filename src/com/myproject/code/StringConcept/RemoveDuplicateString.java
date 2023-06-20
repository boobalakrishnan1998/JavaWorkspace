package com.myproject.code.StringConcept;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
       // String inputStr = sc.nextLine();
      String inputStr="boobalakrishnan";
        inputStr = inputStr.toLowerCase();
        //boobalakrishnan
        if(inputStr.isEmpty()){
            throw new NullPointerException("Input string must not be empty");
        }
        removeDuplicateStringNormal(inputStr);
        removeDuplicateStringBoolean(inputStr);
        removeDuplicateStringSet(inputStr);
        removeDuplicateStringJava8(inputStr);
    }

    private static void removeDuplicateStringJava8(String inputStr) {
        String withoutDuplicateStr= Arrays.asList(inputStr.split("")).stream().distinct().collect(Collectors.joining());
        System.out.println("After remove duplicate  String in Java 8  method :: "+withoutDuplicateStr);
    }

    private static void removeDuplicateStringSet(String inputStr) {
        Set<Character> set =new LinkedHashSet<Character>();
        for(Character c: inputStr.toCharArray()){
            set.add(c);
        }
        System.out.print("After remove duplicate  String in Set method :: ");
        for (Character setChar:set){
            System.out.print(setChar);
        }
    }

    private static void removeDuplicateStringBoolean(String inputStr) {
        char[] charactor= inputStr.toCharArray();
        boolean[] foundBoolean=new boolean[256];
        StringBuilder sb=new StringBuilder();
        for(char c:charactor){
            if(!foundBoolean[c]){
                foundBoolean[c]=true;
                sb.append(c);
            }
        }
        System.out.println("After remove duplicate  String in Boolean method :: "+sb);
    }

    private static void removeDuplicateStringNormal(String inputStr) {
        char[] inputCharArray = inputStr.toCharArray();
        int inputStrLength = inputCharArray.length;
        for (int i = 0; i < inputStrLength; i++) {
            for (int j = i + 1; j < inputStrLength; j++) {
                if (inputCharArray[i] == inputCharArray[j]) {
                    for (int k = j; k < inputStrLength-1; k++) {
                        inputCharArray[k] = inputCharArray[k+1];
                    }
                    inputStrLength--;
                    j--;
                }
            }

        }
        String removedDuplicateChar =new String(inputCharArray);
        removedDuplicateChar = removedDuplicateChar.substring(0,inputStrLength);
        System.out.println("After remove duplicate  String in Normal method :: "+removedDuplicateChar);
    }

}
