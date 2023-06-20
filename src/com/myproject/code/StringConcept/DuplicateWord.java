package com.myproject.code.StringConcept;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*Dhoni is a great player He is the one of the best wicket keeper Sachin is the god of cricket
virat is the current best player but I like Dhoni. in above string how many times Dhoni,
 Sachin and virat is there.*/
public class DuplicateWord {

    public static void main(String[] args) {

        String str="Dhoni is a great player He is the one of the best wicket keeper Sachin is the god of cricket\n" +
                "virat is the current best player but I like Dhoni";
        String[] keyArr=new String[]{"Dhoni","Sachin","Virat"};
        Map<String,Integer> map=new HashMap<>();
        String[] strArr= str.split(" ");
        for(String temStr:strArr){
            if(map.containsKey(temStr)){
                map.put(temStr,(map.get(temStr)+1));
            }else {
                map.put(temStr,1);
            }
        }
        for(Map.Entry entry: map.entrySet()){
            if(Arrays.asList(keyArr).contains(entry.getKey())){
                System.out.println(entry.getKey()+""+" "+entry.getValue());
            }
        }
    }
}
