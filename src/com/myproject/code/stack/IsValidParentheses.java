package com.myproject.code.stack;

import java.util.Stack;

public class IsValidParentheses {

    public static void main(String[] args) {
        String input="(({[]]}))";
      boolean isValid=  isValidParantheses(input);

    }

    public static boolean isValidParantheses(String input) {
     if(input.length()%2==1){
         return false;
     }
        Stack<Character> stack=new Stack<>();
        for(Character c:input.toCharArray()){
            if(c=='('){
                stack.add(')');
            } else if (c=='{') {
                stack.add('}');
            } else if (c=='[') {
                stack.add(']');
            } else if (stack.isEmpty() || stack.pop()!=c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
                continue;
            }
            if (st.isEmpty()) {
                return false;
            } else if ((c == ')' && st.pop() != '(') || (c == ']' && st.pop() != '[') || (c == '}' && st.pop() != '{') ) {
                return false;
            }
        }
        return st.isEmpty();
    }
}
