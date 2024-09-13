package com.myproject.code.stack;

import java.util.Stack;

public class SimplifyPath {
    //Input: path = "/home/user/Documents/../Pictures"
    //Output: "/home/user/Pictures"
    public static void main(String[] args) {
        String input = "/home/user/Documents/../Pictures";
        String ans = simplifyPath(input);
        System.out.println(ans);
    }

    public static String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> st = new Stack<>();
        for (String s : str) {
            if (s.equals(".") || s.equals("")) {
                continue;
            }
            if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(s);
            }
        }
        /// if (st.isEmpty()) {
        //    return "/";
        // }
        return "/" + String.join("/", st);
    }
}
