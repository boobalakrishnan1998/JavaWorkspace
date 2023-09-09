package com.myproject.code.StringConcept;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcadaaj");
        lengthOfLongestSubstr("abcadaaj");

    }
    public static int lengthOfLongestSubstr(String s) {

        Map<Character,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int longLen=0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                left=Math.max(map.get(s.charAt(right))+1,left);
            }
            map.put(s.charAt(right),right);
            longLen=Math.max(longLen,right-left+1);
            right++;
        }
        return longLen;
    }

        public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int logestSubStr = 0;
        int startPoint = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                logestSubStr = Math.max(map.size(),logestSubStr);
                map.clear();
                i = ++startPoint;
            } else {
                map.put(s.charAt(i), i);
            }
        }
        return logestSubStr;
    }




}
