package com.fonxian.leetcode.leetcode232;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * @author Michael Fang
 * @since 2020-03-28
 */
public class MyQueue {

    private Stack<Integer> stackSource;
    private Stack<Integer> stackSink;
    private int size = 0;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackSource = new Stack<>();
        stackSink = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackSource.push(x);
        size ++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stackSink.empty()){
            size --;
            return stackSink.pop();
        }
        while(!stackSource.empty()){
            stackSink.push(stackSource.pop());
        }
        if(stackSink.empty()){
            return -1;
        }
        size --;
        return stackSink.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!stackSink.empty()){
            return stackSink.peek();
        }
        while(!stackSource.empty()){
            stackSink.push(stackSource.pop());
        }
        if(stackSink.empty()){
            return -1;
        }
        return stackSink.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }

}
