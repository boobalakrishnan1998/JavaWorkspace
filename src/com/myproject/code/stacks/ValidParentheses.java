package com.myproject.code.stacks;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String str = "{}()[]";
        boolean ans = isValid(str);
        System.out.println(ans);
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
                continue;
            }
            if (st.isEmpty()) {
                return false;
            } else if ((c == ')' && st.pop() != '(') ||
                    (c == ']' && st.pop() != '[') ||
                    (c == '}' && st.pop() != '{')) {
                return false;
            }
        }
        return st.isEmpty();
    }
}
