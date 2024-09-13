package com.myproject.code.queue;

import java.util.LinkedList;
import java.util.Queue;

/*Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]*/
public class ImplementStackUsingQueue {
    //Using Single Queue
    Queue<Integer> queue1 = new LinkedList<>();
    public ImplementStackUsingQueue() {

    }
    public void push(int x) {
        queue1.add(x);
        for(int i=0;i<queue1.size()-1;i++){
            queue1.add(queue1.remove());
        }
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */