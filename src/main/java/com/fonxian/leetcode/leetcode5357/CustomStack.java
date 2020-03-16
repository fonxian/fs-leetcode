package com.fonxian.leetcode.leetcode5357;


/**
 * https://leetcode-cn.com/contest/weekly-contest-180/problems/design-a-stack-with-increment-operation/
 *
 * status:AC
 *
 * @author Michael Fang
 * @since 2020-03-15
 */
public class CustomStack {

    private int maxSize;
    private int topPosition = 0;
    private int[] list;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        topPosition = 0;
        list = new int[maxSize + 1];
    }

    public void push(int x) {
        if (topPosition < maxSize) {
            list[topPosition + 1] = x;
            topPosition++;
        }
    }

    public int pop() {
        if (topPosition != 0) {
            int pop = list[topPosition];
            topPosition--;
            return pop;
        }
        return -1;
    }

    public void increment(int k, int val) {
        k = k > topPosition ? topPosition : k;
        for (int i = 1; i <= k; i++) {
            list[i] = list[i] + val;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        System.out.println(customStack.pop());
        customStack.push(2);                          // 栈变为 [1, 2]
        customStack.push(3);                          // 栈变为 [1, 2, 3]
        customStack.push(4);
        customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
        customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
        System.out.println(customStack.pop());               // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        System.out.println(customStack.pop());                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        System.out.println(customStack.pop());                         // 返回 201 --> 返回栈顶值 201，栈变为 []
        System.out.println(customStack.pop());                       // 返回 -1 --> 栈为空，返回 -1

    }
}
