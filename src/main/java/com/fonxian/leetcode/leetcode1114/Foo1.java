package com.fonxian.leetcode.leetcode1114;

/**
 * @author Michael Fang
 * @since 2020-03-28
 */
class Foo1 {
    private  volatile int one = 0;
    public Foo1() {

    }

    public  void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        one ++;
    }

    public  void second(Runnable printSecond) throws InterruptedException {
        while(one !=1){
            System.out.println(one);
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        one++;
    }

    public  void third(Runnable printThird) throws InterruptedException {
        while(one != 2){
            System.out.println(one);

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
