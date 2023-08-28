package com.myproject.code.StringConcept;

public class StringFn {

    public static void main(String[] args) {
        String str="abcd45 ABCD !23";
        for(int i=0;i<str.length();i++){
            if(Character.isSpaceChar(str.charAt(i))){
               System.out.print(str.charAt(i));
            }
            if(Character.isLetterOrDigit(str.charAt(i))){
              //  System.out.print(str.charAt(i));
            }
            if(Character.isLetterOrDigit(str.charAt(i))){
                System.out.print(str.charAt(i));
            }
        }
    }





}
