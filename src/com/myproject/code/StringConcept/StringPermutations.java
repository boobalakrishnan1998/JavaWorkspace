package com.myproject.code.StringConcept;

/**
 * Java program to find all permutations of a given String using recursion. * For example, given a String "XYZ", this program will print * all 6 possible permutations of * input e.g. XYZ, XZY, YXZ, YZX, ZXY, XYX * * @author Javin Paul
 */
public class StringPermutations {
    public static void main(String args[]) {
        permutation("","123");
    }
    /* * A method exposed to client to calculate permutation of String in Java. */
    private static void permutation(String perm, String word) {
        if(word.isEmpty()){
            System.out.println(perm);
        }
        for(int i=0;i<word.length();i++){
            String str=perm+word.charAt(i);
            String rightSubstr=word.substring(0,i);
            String leftSubstr=word.substring(i+1);
             permutation(str,rightSubstr+leftSubstr);
         }
    }
}