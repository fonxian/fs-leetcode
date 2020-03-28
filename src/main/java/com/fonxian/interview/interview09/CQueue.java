package com.fonxian.interview.interview09;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 *
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author Michael Fang
 * @since 2020-03-21
 */
public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.empty()){
            return stack2.pop();
        }
        while(stack1.size() != 0){
            stack2.push(stack1.pop());
        }
        if(stack2.empty()){
            return -1;
        }
        return stack2.pop();
    }

}
