package com.myproject.code.StringConcept;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class MaxOccuringChar {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the String ");
        String str=sc.nextLine();
        Integer max=0;
        char MaxOccurChar = 0;
        HashMap<Character,Integer> map=new HashMap<>();
        char[] ch=str.toLowerCase(Locale.ROOT).toCharArray();
        for(int i=0;i<ch.length;i++){
            if(map.containsKey(ch[i])){
                map.put(ch[i],map.get(ch[i])+1);
            }else{
                map.put(ch[i],1);
            }
        }
        for(Map.Entry cha:map.entrySet()){


            if(Integer.parseInt(cha.getValue().toString()) >= max){
                max=Integer.parseInt(cha.getValue().toString());
                MaxOccurChar= (char) cha.getKey();
            }

        }

        System.out.println("Maximum Occured Character  " +MaxOccurChar);
    }




}
