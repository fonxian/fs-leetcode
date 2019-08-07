package com.fonxian.leetcode020;

import java.util.Stack;

/**
 * @author Michael Fang
 * @since 2019-08-08
 */
public class Solution {

    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack stack = new Stack();
        for (char c : charArray) {
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }
            String result = String.valueOf(stack.peek()) + String.valueOf(c);
            if (result.equals("{}") || result.equals("[]") || result.equals("()")) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{[]}";
        System.out.println(isValid(str));
    }

}
