package com.myproject.code.StringConcept;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcadaaj");
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
