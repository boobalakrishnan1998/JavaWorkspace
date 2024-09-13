package com.myproject.code.stack;

import java.util.Stack;
/*Input
        ["MyQueue", "push", "push", "peek", "pop", "empty"]
        [[], [1], [2], [], [], []]
        Output
        [null, null, null, 1, 1, false]*/
public class ImplementQueueUsingStack {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        public ImplementQueueUsingStack() {

        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                moveStack();
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                moveStack();
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        public void moveStack() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */