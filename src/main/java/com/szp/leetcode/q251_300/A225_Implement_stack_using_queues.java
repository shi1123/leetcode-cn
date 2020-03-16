package com.szp.leetcode.q251_300;

import java.util.*;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
public class A225_Implement_stack_using_queues {
    class MyStack {
        private Queue<Integer> q1 = new LinkedList<>();
        /** Initialize your data structure here. */
        public MyStack() {
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if(q1.isEmpty())
                return -1;
            Iterator<Integer> it = q1.iterator();
            Integer result = -1;
            while(it.hasNext()){
                result = it.next();
                if(!it.hasNext())
                    it.remove();
            }
            return result;
        }

        /** Get the top element. */
        public int top() {
            if(q1.isEmpty())
                return -1;
            Iterator<Integer> it = q1.iterator();
            Integer result = -1;
            while(it.hasNext()){
                result = it.next();
            }
            return result;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
           return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
//        A225_Implement_stack_using_queues.MyStack
    }
}
