package com.myproject.code.StringConcept;

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
}
