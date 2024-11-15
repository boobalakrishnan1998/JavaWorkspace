package com.myproject.code.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aabb";
        ArrayList<String> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        findPalindromePartition(0, s, path, ans);
        //TODO Understand the logic and work out with the array list types
        System.out.println(ans);
    }

    static void findPalindromePartition(int ind, String str, ArrayList<String> path, List<List<String>> ans) {
        if (ind == str.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = ind; i < str.length(); i++) {
            if (isPalindrome(str, ind, i)) {
                path.add(str.substring(ind,i + 1));
                findPalindromePartition(i+ 1, str, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
