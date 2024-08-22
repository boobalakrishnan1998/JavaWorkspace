package com.myproject.code.arrayConcept;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithOutRepeatingCharacter {

    public static void main(String[] args) {
        String str = "abcabcdba";
       int ans = findLongestSubstring(str);
       System.out.println(ans);
    }

    private static int findLongestSubstring(String str) {
        int n = str.length();
        int left = 0, right = 0;
        int longestSubString = 0;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        while (right < n) {
            if (hash[str.charAt(right)] != -1) {
                left = Math.max(hash[str.charAt(right)] + 1, left);
            }
            longestSubString = Math.max(longestSubString, right - left + 1);
            hash[str.charAt(right)] = right;
            right++;
        }
        return longestSubString;
    }
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        int longestLen = 0;
        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1,l);
            }
            longestLen = Math.max(longestLen, r - l + 1);
            map.put(s.charAt(r), r);
            r++;
        }
        return longestLen;
    }
}
