package com.fonxian.leetcode.leetcode1114;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Michael Fang
 * @since 2020-03-28
 */
public class Foo {

    private AtomicInteger atomicOne = new AtomicInteger();
    private AtomicInteger atomicTwo = new AtomicInteger();
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        atomicOne.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(atomicOne.get() !=1){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        atomicTwo.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(atomicTwo.get() != 1){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
