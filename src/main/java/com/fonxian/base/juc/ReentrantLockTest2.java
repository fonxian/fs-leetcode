package com.fonxian.base.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Michael Fang
 * @since 2019-10-15
 */
@SuppressWarnings("all")
public class ReentrantLockTest2 {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                fun();
            }
        };
        t1.setName("线程1");
        t1.start();
        try {
            TimeUnit.MILLISECONDS.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main");
        LockSupport.unpark(t1);
    }


    static void fun() {

        try {
            TimeUnit.MILLISECONDS.sleep(20L);
            System.out.println("test111111");
            LockSupport.park();
            System.out.println("test222222");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
