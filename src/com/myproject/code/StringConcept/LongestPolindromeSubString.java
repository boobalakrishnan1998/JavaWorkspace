package com.myproject.code.StringConcept;

public class LongestPolindromeSubString {
    public static void main(String[] args) {
        String input = "babad";
       String sub= findLongestSubString(input);
    }
    public static String findLongestSubString(String input) {
        int start=0;
        int end=0;
        for (int i = 0; i < input.length(); i++) {
         int len1= findPolindromeFromMiddle(input,i,i);
         int len2= findPolindromeFromMiddle(input,i,i+1);
         int len=Math.max(len1,len2);
         if(len>end-start){
             start=i-((len-1)/2);
             end=i+(len/2);
         }
        }
        return input.substring(start,end);
    }

    public static int findPolindromeFromMiddle(String input,int left,int right) {
        while(left>=0&&right<input.length()&&input.charAt(left)==input.charAt(right)){
         left--;
         right++;
        }
        return right-left-1;
    }
}