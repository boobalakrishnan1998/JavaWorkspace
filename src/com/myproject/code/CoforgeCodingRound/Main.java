package com.myproject.code.CoforgeCodingRound;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
/*
    You are given a file named input.txt that contains three lines. Each line represents a string. Write a Java function that reads the strings from the file and finds and returns the length of the longest substring without repeating characters in each string.
*/

    public static void main(String[] args) throws FileNotFoundException {
        String filePath="C:\\Users\\boobalakrishnan.v\\Documents\\CodeTest\\src\\input";
        List<Integer> longestLen=  findAllLongestSubString(filePath);
        longestLen.forEach(System.out::println);
    }


    public static List<Integer> findAllLongestSubString(String filePath) throws FileNotFoundException {
        List<String> list= getStringFromFile(filePath);
        List<Integer> longestLen=new ArrayList<>();
         for(String input:list){
             longestLen.add(findLongestSubString(input));
         }
        return longestLen;
    }
    public static List<String> getStringFromFile(String filePath) throws FileNotFoundException {
       List<String> list= new ArrayList<>();
        File file=new File(filePath);
        Scanner sc=new Scanner(file);
        while (sc.hasNextLine()){
            list.add(sc.nextLine());
        }
        if(list.isEmpty())
            throw new InputMismatchException();
        return list;
    }

    public static Integer findLongestSubString(String input){
   //Left  //a b c a b c b b //Right
           //0 1 2 3 4 5 6 7
        Map<Character,Integer> map=new HashMap<>();
        int right=0;
        int left=0;
        int longestLen=0;
        while (right<input.length()){
            if(map.containsKey(input.charAt(right))){
                left=Math.max(map.get(input.charAt(right))+1,left);
            }
            map.put(input.charAt(right),right);
            longestLen=Math.max(longestLen,right-left+1);
            right++;
        }
     return longestLen;
    }
}