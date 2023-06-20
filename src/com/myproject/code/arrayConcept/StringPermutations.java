package com.myproject.code.arrayConcept;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class StringPermutations {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
       String str= sc.nextLine();
       //permuatations("",str);
        permuataion("",str);

    }

    private static void permuatations(String perm, String word) {
        if(word.isEmpty()){
            System.out.println(perm);
        }
        for(int i=0;i<word.length();i++){
            permuatations(perm+word.charAt(i),word.substring(0,i)+word.substring(i+1));
        }

    }

    public static ArrayList<String> permuataion(String perm, String word){
        ArrayList<String> al=new ArrayList<>();
        if(word.isEmpty()){
            al.add(perm);
        }
        for(int i=0;i<word.length();i++){
            String str=perm+word.charAt(i);
            String rightSubstr=word.substring(0,i);
            String leftSubstr=word.substring(i+1);
            al.addAll(permuataion(str,rightSubstr+leftSubstr));
        }
        return al;
    }

}
