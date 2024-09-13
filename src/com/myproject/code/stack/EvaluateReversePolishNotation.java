package com.myproject.code.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /*Input: tokens = ["2","1","+","3","*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9*/
    public static void main(String[] args) {
        String[] input =new String[]{"2","1","+","3","*"};
        int ans = evalRPN(input);
        System.out.println(ans);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {

            if (s.equals("+")) {
                int second = st.pop();
                int first = st.pop();
                st.push(first + second);
            } else if (s.equals("-")) {
                int second = st.pop();
                int first = st.pop();
                st.push(first - second);
            } else if (s.equals("*")) {
                int second = st.pop();
                int first = st.pop();
                st.push(first * second);

            } else if (s.equals("/")) {
                int second = st.pop();
                int first = st.pop();
                st.push(first / second);

            } else {
                st.push(Integer.valueOf(s));
            }
        }
        System.out.println(st);
        return st.peek();
    }}
