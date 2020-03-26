package com.fonxian.base.jvm.optimize;

import java.util.concurrent.TimeUnit;

/**
 * @author Michael Fang
 * @since 2020-03-26
 */
public class DeadLockTest {

    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(() -> {
                synchronized (lock1){
                    System.out.println("A get lock1");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("A get lock2");
                    }
                }
            System.out.println("A finish");
        }).start();

        new Thread(() -> {
            synchronized (lock2){
                System.out.println("B get lock2");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("B get lock2");
                }
            }
            System.out.println("B finish");
        }).start();
    }

}
