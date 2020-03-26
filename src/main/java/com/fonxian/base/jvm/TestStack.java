package com.fonxian.base.jvm;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Michael Fang
 * @since 2020-02-18
 */
public class TestStack {

     static class Test implements Runnable{

        @Override
        public void run() {
            System.out.println("test");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int math() {
        int a = 1;
        int b = 2;
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        TestStack testStack = new TestStack();
        System.out.println(testStack.math());
//        try {
//            Thread t1 = new Thread(new Test());
//            t1.start();
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("----------");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("b");

    }

}
