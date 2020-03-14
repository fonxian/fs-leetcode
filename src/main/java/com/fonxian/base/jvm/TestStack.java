package com.fonxian.base.jvm;

/**
 * @author Michael Fang
 * @since 2020-02-18
 */
public class TestStack {

    public int math() {
        int a = 1;
        int b = 2;
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        TestStack testStack = new TestStack();
        System.out.println(testStack.math());
    }

}
