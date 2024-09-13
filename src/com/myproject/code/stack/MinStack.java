package com.myproject.code.stack;

import java.util.Stack;
/*Input
        ["MinStack","push","push","push","getMin","pop","top","getMin"]
        [[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
        */
public class MinStack {

    private Stack<Long> stack;
    private long minElement;

    public MinStack() {
        stack = new Stack<>();
        minElement = Long.MAX_VALUE;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            minElement = val;
            stack.push((long)val);
        } else {
            if (val < minElement) {
                stack.push(2L * val - minElement);
                minElement = val;
            } else {
                stack.push((long)val);
            }
        }
    }

    public void pop() {
        if (stack.peek() < minElement) {
            minElement = 2 * minElement - stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        if (stack.peek() < minElement) {
            return (int)minElement;
        }
        return stack.peek().intValue();
    }

    public int getMin() {
        return (int)minElement;
    }

}